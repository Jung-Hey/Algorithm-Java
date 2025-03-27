import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int to;
	double cost;
	public Edge(int to, double cost) {
		super();
		this.to = to;
		this.cost = cost;
	}
   @Override
    public int compareTo(Edge e) {
        return Double.compare(this.cost, e.cost);
    }
	@Override
	public String toString() {
		
		return "Egde["+" to = "+to+" cost = "+cost + "]";
	}
   

}


public class Solution {
	static StringBuilder sb;
	static ArrayList<ArrayList<Edge>> graph;
	static long answer;
	static int n;

	//환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			graph = new ArrayList<>();
			answer = 0; // 총 가중치
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken()); // 섬의 수
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
			int [] pointX = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int [] pointY = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			double e = Double.parseDouble(br.readLine()); // 세율
			// 간선 세팅
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					//int dis = Math.abs(pointX[i]-pointX[j]) + Math.abs(pointY[i]-pointY[j]);
					double dis =  Math.pow(pointX[i] - pointX[j], 2) + Math.pow(pointY[i] - pointY[j], 2);
					double cost = dis;
					graph.get(i).add(new Edge(j, cost));
					graph.get(j).add(new Edge(i, cost));
					
					//graph.get(j).add(new Edge(i, cost));
				}
			}
			prim();

			
			
			sb.append("#").append(t).append(" ").append(Math.round(answer*e)).append("\n");
		}
		//output
		System.out.println(sb);
	
		
	}

	private static void prim() {
		int edgeCount=0;
		boolean [] isVisited = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 시작정점은 0 번째 정점으로 세팅
		pq.offer(new Edge(0, 0));
		// prim
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(isVisited[now.to]) continue;
			
			isVisited[now.to] = true;
			answer += now.cost;
			if (++edgeCount == n) break;  // 모든 섬이 연결되면 종료
			
			
			for(Edge nv : graph.get(now.to)) {
				if(!isVisited[nv.to]) pq.offer(new Edge(nv.to, nv.cost));
			}
			
		}
		
	}

}
