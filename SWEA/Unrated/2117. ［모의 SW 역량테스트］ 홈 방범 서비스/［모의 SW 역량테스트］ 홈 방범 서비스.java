import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 107,540 kb
 * 390 ms
 */
public class Solution {

	static StringBuilder sb;
	static int answer, maxProfit;
	static int [][] arr;
	static int n,m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken()); // 도시의 크기
			m = Integer.parseInt(st.nextToken()); // 집이 지불가능한 비용
			arr = new int[n][n];
			sb.append("#").append(t).append(" ");
			int homeCount=0;
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < n; j++) {
					if(arr[i][j]==1) homeCount++;
				}
			}
			// solve
			
			maxProfit = m-1; // k=1 일때 집하나의 수익 - 운영비용
			answer = maxProfit >= 0 ? 1 : 0;
			int k=2;
			while(true) {
				int operateCost = getOperateCost(k);
				//System.out.println("k 가 "+k +" 일때 운영비용 = "+operateCost);
				// 운영비용이 모든 집들의 운영비용의 합보다 비싸면 종료
				if (k > n+1 ) break;
				if( (m*homeCount < operateCost) ) break;
				// k 크기의 구역에 대해 집들의 수익을 구함
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						startSerive(i,j,k,operateCost);
					}
				}
				k++;
			}
			sb.append(answer).append("\n");
		}
		//output
		System.out.println(sb);
	
	}

	// 방법 서비스 시작, 이득일 시 최대 집 수 갱신 
	private static void startSerive(int x, int y, int k, int operateCost) {
		int findHomeCount=0;
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		boolean [][] visited = new boolean[n][n];
		visited[x][y] = true;
		if(arr[x][y] == 1) findHomeCount++;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		// bfs
		for (int i = 1; i < k; i++) {
			int len = q.size();
			for (int j = 0; j < len; j++) {
				int [] now = q.poll();
				// 현재 위치가 집이면 카운팅
				for (int l = 0; l < 4; l++) {
					int nx = now[0] + dx[l];
					int ny = now[1] + dy[l];
					if(nx<0 || nx >=n || ny < 0 || ny >= n) continue;
					if(!visited[nx][ny]) {
						visited[nx][ny]=true; //방문처리
						q.offer(new int[] {nx,ny});
						if(arr[nx][ny] == 1 )findHomeCount++;
					}
				}
			}
		}
		// 기존 수익보다 높은 수익을 얻으면 갱신
		if((findHomeCount * m ) - operateCost >= 0) {
			answer = Math.max(answer, findHomeCount);
		}
		
	}


	// 입력 k 에 대한 운영비용 반환
	private static int getOperateCost(int k) {
		int cost = 0;
		cost += k*2 -1; // + 3
		for (int i = 1; i < k*2 -1; i+=2) {
			cost += i*2;
		}
		return cost;
	}

}
