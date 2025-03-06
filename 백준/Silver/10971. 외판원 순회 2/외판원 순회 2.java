import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

	static ArrayList<ArrayList<int[]>> graph;
	static boolean[] isVisited;
	static int n;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<int[]>>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < n; i++) {
			int [] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < n; j++) {
				if(edge[j] != 0) graph.get(i).add(new int[] {j, edge[j]} );
			}
		}
	
		// solve
		for (int i = 0; i < n; i++) {
			isVisited = new boolean[n];
			isVisited[i] = true;
			dfs(i,i,0);
		}
		//out
		System.out.println(answer);
		
	}
	private static void dfs(int level, int now, int cost) {
        if(answer < cost) return; // 가지치기

		// 전부 순회했다면 
		if(isAllVisited()) {
			// 시작 지점으로 돌아갈 수 있어야 함
			if(level == now) return;
			// 현재 노드에서 출발 노드로의 거리 더해줌(마지막으로 원래 노드로 돌아감)
			for(int[] endNodeEdges : graph.get(now)) {
				if(endNodeEdges[0] == level) {
					cost += endNodeEdges[1];
					answer = Math.min(answer, cost);
				}
			}
		}
		else {
			for (int [] node : graph.get(now)) {
				// 방문하지 않았고 길(경로)이 있으면 탐색 
				if(!isVisited[node[0]]) {
					isVisited[node[0]] = true;
					dfs(level, node[0], cost+node[1]);
					isVisited[node[0]] = false;
				} 
			}
			
		}
		
	}
	private static boolean isAllVisited() {
		for (int i = 0; i < n; i++) {
			if(!isVisited[i]) return false;
		}
		return true;
	}
}