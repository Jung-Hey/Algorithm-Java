import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static List<int[]> randGraph;
	static int[] unf;
	static int[][] arr;
	static int n,m, landCount;
	
	public static int find(int v) {
		if(unf[v] == v) {
			return v;
		}
		else {
			return unf[v] = find(unf[v]);
		}
	}
	
	public static void union(int a, int b) {
		int fa = find(a);
        int fb = find(b);
		if(find(a) != find(b)) {
			unf[fa] = fb;
		}
		
	}
	public static void main(String[] args) throws IOException {
	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// input
		landCount = 0;
		randGraph = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int answer=0;
		for (int i = 0; i < n; i++) {
			String[] row = br.readLine().split(" ");
			arr[i]= Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
		}
		
		// solve
		// 섬의 개수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) { // 섬 찾기
					landCount++;
					arr[i][j] = 0-landCount; // 초기화 
					bfs(i,j);
				}
			}
		}
		//System.out.println(landCount);
		// 섬의 관계 배열 초기화 
		unf = new int[landCount+1];
		for (int i = 1; i <= landCount;  i++) {
			unf[i]=i;
		}

		// 섬의 다리 잇기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] < 0 ) {
					linkedBrigde(i,j);
				}
			}
		}
		randGraph.sort((a,b)-> a[2]-b[2]);
		for(int[] t : randGraph) {
			int from = t[0];
			int to = t[1];
			if(find(from) != find(to) ) {
				union(from, to);
				set.add(from);
				set.add(to);
				answer += t[2];
			}			
		}
		//모든 섬을 연결하는 다리 길이의 최솟값을 출력. 모든 섬을 연결하는 것이 불가능하면 -1
		int root = find(1);
for(int i = 2; i <= landCount; i++){
    if(find(i) != root){
        System.out.println(-1);
        return;
    }
}
		System.out.println(answer);
		
		
		
		
    }

	private static void linkedBrigde(int x, int y) {

		for (int j = 0; j < 4; j++) {
			int dis=1;
			int nx = x;
			int ny = y;
			// 벽을 만날때까지 
			while( true ) {
				nx += dx[j];
				ny += dy[j];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				if(arr[nx][ny] == arr[x][y]) break; // 자기 자신
				// 다른 섬을 찾음 
				if(arr[nx][ny] < 0 ) { 
					if(dis-1 == 1) break; // 거리가 1인 다리는 없음
					// [ vex1, vex2, 가중치] 정보 추가
					//System.out.println(x+" "+y+" "+nx+ " " +ny+"   "+"to : "+ Math.abs(arr[x][y])+ " from : "+Math.abs(arr[nx][ny]) + " cost : "+(dis-1) );
					randGraph.add(new int[] { Math.abs(arr[x][y]), Math.abs(arr[nx][ny]), (dis-1) } );				
					break;
				}
				dis++;
				
				
			}
		}
		
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
	
		while(!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = tmp[0] + dx[j];
					int ny = tmp[1] + dy[j];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(arr[nx][ny] == 1) {
						arr[nx][ny] = 0-landCount; // 초기화 
						q.offer(new int[] {nx, ny});
					}
				}
		}
	}

	
	
}

