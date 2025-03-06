import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] graph;
	static boolean[] isVisited;
	static int n;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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
	private static void dfs(int l, int now, int cost) {
        if(answer < cost) return; // 가지치기
		// 전부 순회했다면 
		if(isAllVisited()) {
			if(graph[now][l] != 0) { // 돌아갈 수 있어야 함
				cost += graph[now][l]; // 마지막으로 원래 노드로 돌아감
				answer = Math.min(answer, cost);
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				// 방문하지 않았고 길이 있으면 탐색 
				if(!isVisited[i] && graph[now][i] != 0) {
					isVisited[i] = true;
					dfs(l, i, cost+graph[now][i]);
					isVisited[i] = false;
				} // 
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