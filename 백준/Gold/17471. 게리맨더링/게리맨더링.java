import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int [] population;
	static boolean [] zone;
	static int subsetCount=0;
	static int n;
	
	static int answer = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> graph;
	
	
	public static void main(String[] args) throws IOException {
	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine()); // 구역의 수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 각 정점의 인구수 배열
		population = new int[n+1]; 
		zone = new boolean[n+1];
		// 각 구역의 그래프 
		graph = new ArrayList<>(); 
		
	
		// 1~n 구역(정점)의 인구 수 할당 
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>()); // 각 정점별 초기화 
		}
		graph.add(new ArrayList<>()); 
		
		// 그래프 연결
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int vex1 = i;
			int m = Integer.parseInt(st.nextToken()); // vex1 과 연결된 정점의 수
			for (int j = 0; j < m; j++) {
				int vex2 = Integer.parseInt(st.nextToken());
				graph.get(vex1).add(vex2);
			}
		}
		
		dfs(1);
		System.out.println( answer == Integer.MAX_VALUE ? -1 : answer);
		
    }
	
	/*
	 * 각 구역들의 부분집합 
	 */
	private static void dfs(int l) {
		if( l == n+1) {
			if(subsetCount > 0 && subsetCount < n) {
				// 두 개의 선거구로 나누고 가능한 경우의 두 선거구의 인구 차이의 최솟값 출력 
				getMinDiff();
			}
		}
		else {
			zone[l] = true;
			subsetCount++;
			dfs(l+1);
			zone[l] = false;
			subsetCount--;
			dfs(l+1);
		}
		
	}

	private static void getMinDiff() {

		int aTotal=0;// A 선거구의 인구수 합 
		int bTotal=0;// A 선거구의 인구수 합 
		int findAZoneCount = 0; // 탐색 성공한 A 구역의 개수
		int findBZoneCount = 0; // 탐색 성공한 B 구역의 개수
		
		int anyZoneA = 0;
		int anyZoneB = 0;
		
		for(int i=1; i<=n; i++) {
			if(zone[i]) {
				anyZoneA = i; // A선거구에 해당하는 구역 나오면 바로 선택 후 멈춤 
				break;
			}
		}
		for(int i=1; i<=n; i++) {
			if(!zone[i]) {
				anyZoneB = i; // B선거구에 해당하는 구역 나오면 바로 선택 후 멈춤 
				break;
			}
		}

		// 선거구 탐색에 쓰일 그래프
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		
//		System.out.println("anyZoneA : "+anyZoneA);
//		System.out.println(graph.get(anyZoneA));

		
		// 최초 A구역 초기화 
		q.offer(anyZoneA); 
		findAZoneCount++;
		aTotal += population[anyZoneA];
		visited[anyZoneA] = true;
		// A 선구에 탐색
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int nv : graph.get(node)) {
				if(zone[nv] && !visited[nv] ) { // A 구역이면
					visited[nv] = true;
					q.offer(nv);
					findAZoneCount++;
					aTotal += population[nv];
				}
			}
		}
		// 최초 B구역 초기화 
		q.offer(anyZoneB); 
		findBZoneCount++;
		visited[anyZoneB] = true;
		bTotal += population[anyZoneB];
		// B 선거구에 탐색
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int nv : graph.get(node)) {
				if(!zone[nv] && !visited[nv]) { // B 구역이면
					visited[nv] = true;
					q.offer(nv);
					findBZoneCount++;
					bTotal += population[nv];
				}
			}
		}
//		System.out.println("b 구역 탐색 완료");
//		System.out.println("findAZoneCount + findBZoneCount = " + (findAZoneCount+findBZoneCount) );
		
		if( (findAZoneCount+findBZoneCount) == n) {
			answer = Math.min(answer, Math.abs(aTotal - bTotal));
		}
		
	}


	
}