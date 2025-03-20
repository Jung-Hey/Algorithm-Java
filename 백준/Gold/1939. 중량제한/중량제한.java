import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<int[]>> graph;
	static int lt=1,rt,n;
	public static void main(String[] args) throws Exception {
		graph = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new int[] {to,cost});
			graph.get(to).add(new int[] {from,cost});
			rt = Math.max(rt, cost);
		}
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		while(lt <= rt) {
			int mid = (lt+rt) / 2;
			boolean [] isVisited = new boolean[n+1];
			// 운반 가능함 -> 최대무게를 구해야 하므로 더 높혀서 시도해볼 수 있음!
			if(dfs(from,to,mid,isVisited)) { 
				lt = mid+1;
			}
			else {
				rt = mid -1;
			}
			
		}
		System.out.println(rt);

	}
	private static boolean dfs(int from, int to, int mid, boolean [] isVisited) {
		if(from == to) {
			return true;
		}
//		else {
//			isVisited[from] = true;
//			for (int[] nv : graph.get(from)) {
//				if(!isVisited[nv[0]] && mid >= nv[1]) {
//					if(dfs(nv[0],to,mid, isVisited)) return true;
//				}
//			}
//			
//			return false;
//		}
		  isVisited[from] = true;  // 현재 노드를 방문한 것으로 표시

	        for (int[] nv : graph.get(from)) {
	            int nextNode = nv[0];
	            int weight = nv[1];

	            // 다음 노드가 아직 방문되지 않았고, 현재 중량(mid)이 간선의 중량보다 크거나 같으면 탐색
	            if (!isVisited[nextNode] && weight >= mid) {
	                if (dfs(nextNode, to, mid, isVisited)) {
	                    return true;  // 경로를 찾으면 true 반환
	                }
	            }
	        }

	        return false;  // 경로가 없으면 false 반환
		
	}

}
