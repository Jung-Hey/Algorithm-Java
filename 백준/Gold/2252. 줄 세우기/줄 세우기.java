
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	
	
	public static void main(String[] args) throws IOException {
	 
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 비교 횟수
		
		int [] indegree = new int[n+1]; // 진입차수 배열 
		
		ArrayList<ArrayList<Integer>> studentGraph = new ArrayList<>();
		
		// 학생 수만큼 그래프 초기화 
		for (int i = 0; i <= n; i++) { 
			studentGraph.add(new ArrayList<>()); 
		}
		
		Queue<Integer> q = new LinkedList<>();
		//
		for (int i = 0; i < m; i++) { 
			st = new StringTokenizer(br.readLine()," ");
			// input : (a b)    a -> b   a가 b의 앞에 서야한다 (b를 하려면 a가 먼저해야 한다)
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			//System.out.print(a +" "+b);
			indegree[b]++; // 진입차수 증가 
			studentGraph.get(a).add(b);
		}
		// 위상정렬 전 진입차수  0 인 학생들은 q에 순서대로 넣음
		for (int i = 1; i <= n; i++) {
			if(indegree[i] == 0 ) q.offer(i);
		}
		// 위상정렬
		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");
			//System.out.println(v +" 추가");
			for(int nv : studentGraph.get(v)) {
				if(--indegree[nv] == 0) {
					q.offer(nv);
				}
			}
		}
		System.out.println(sb);
		

		
    }

	
}



