import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	
	static char [][] map;
	static Point start, end;
	static Queue<Point> wQ = new ArrayDeque<>();
	static int n, m;
    public static void main(String[] args) throws NumberFormatException, IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				// 입력 도착점
				if(map[i][j] == 'D') end = new Point(i, j);
				// 입력 시작점
				else if(map[i][j] == 'S') start = new Point(i, j);
				// 물
				else if(map[i][j] == '*') { // 물
					wQ.offer(new Point(i, j));
				}
			}
		}
		int answer = -1;
		// solve
		answer = bfs();
		System.out.println(answer != -1 ? answer : "KAKTUS");
		
    }
	private static int bfs() {
		int L = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		boolean [][] isVisited = new boolean[n][m];
		// 방문배열 시작위치 초기화
		isVisited[start.x][start.y] = true;
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			// 1. 물 확장
			if(!wQ.isEmpty()) {
				int waterLen = wQ.size();
				for(int i=0; i<waterLen; i++) {
					Point nowWater = wQ.poll();
					for (int j = 0; j < 4; j++) {
						// 물 확장
						int nx = nowWater.x + dx[j];
						int ny = nowWater.y + dy[j];
						if(nx<0|| nx>=n || ny < 0 || ny >=m) continue;
						if(isVisited[nx][ny]) continue;
						
						if(map[nx][ny] == '.') {
							isVisited[nx][ny] = true;
							map[nx][ny]='*';// 물 확장
							wQ.offer(new Point(nx,ny));
						}
						
					}
				}
				//print("water");
			}
			// 2. 고슴도치 이동
			int len = q.size();
			for(int i=0; i<len; i++) {
				Point now = q.poll();
				if(now.x == end.x && now.y == end.y) return L;
				for (int j = 0; j < 4; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					if(nx<0|| nx>=n || ny < 0 || ny >=m) {
						continue;
					}
					if(isVisited[nx][ny]) {
						continue;
					}
					if(map[nx][ny] == '*' || map[nx][ny] == 'X') {
						continue;
					}
					// 방문처리
					isVisited[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
			//print("go");
			L++;
			
		}
		
		return -1;
	}
	private static void print(String type ) {
		System.out.println(type);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
}

