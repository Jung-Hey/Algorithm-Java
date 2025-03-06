import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] arr;
	static int r,c;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		// solve
		System.out.println(bfs());
	}
	private static int bfs() {
		int [][] dis = new int[r][c];
		for (int i = 0; i < r; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
		dis[0][0] = 0;
	
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		
		//bfs
		int level = 1;
		while(!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int [] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];
					if(nx<0||nx>=r || ny < 0 || ny >=c) continue;
					if(arr[nx][ny] == 0) continue;
					if(nx == r-1 && ny == c-1) return level+1;
					if(dis[nx][ny] > level) {
						dis[nx][ny] = level; // 최소거리면 갱신 
						q.offer(new int[] {nx,ny}); 
					}
				} 
			}
			level++;
		}
		return dis[r-1][c-1];
	}


}