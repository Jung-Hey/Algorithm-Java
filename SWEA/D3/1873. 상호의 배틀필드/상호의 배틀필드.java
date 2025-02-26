import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int x,y,h,w, dir;
	static char [][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), t=0;
		StringBuilder sb = new StringBuilder();
		while(t++<tc) {
			// 전차의 위치좌표
			x = -1;
			y = -1; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// input
			h = Integer.parseInt(st.nextToken()); // 맵의 세로크기
			w = Integer.parseInt(st.nextToken()); // 맵의 가로크기
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				if(x == -1) {
					for (int j = 0; j < w; j++) {
						if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
							x = i;
							y = j;
							// 상 우 하 좌 순서
							if(map[i][j] == '^') dir=0;
							else if(map[i][j] == '>') dir=1;
							else if(map[i][j] == 'v') dir=2;
							else dir=3;
							break;
						}
					}
				}
			}
		
			int commandCount = Integer.parseInt(br.readLine()); // 명령어 수
			String command = br.readLine();

			// solve
			for(char cmd : command.toCharArray()) {
				runCommand(cmd);
			}
			// out
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	/**
	 * 
	 * @param cmd : 명령어가 이동관련(>, <, ^, v)이면
	 * 1. 방향을 dir 방향으로 돌림
	 * 2. 방향 좌표가 평지라면 이동
	 *   2-1. 지금있는 좌표 평지로 만들기 (전차가 있다는것은 평지인것)
	 *   2-2. 이동 위치에 전차를 방향을 세팅
	 */
	private static void runCommand(char cmd) {
		switch (cmd) {
			case 'S':
				// 포탄 위치 
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				while( !(nx<0||nx>=h||ny<0||ny>=w) ) {
					// 벽돌벽이면 평지로 만듦
					if(map[nx][ny] == '*') {
						map[nx][ny] = '.';
						break;
					}
					// 강철벽이면 아무일 없다
					else if(map[nx][ny] == '#') break;
					nx+=dx[dir];
					ny+=dy[dir];
				}
				//showState(cmd);
				break;
			case 'L':
				dir = 3; // 왼쪽 방향
				if( y+dy[dir] < 0 || y+dy[dir] >= w) {
					map[x][y] = '<';
					break;
				}
				// 이동가능하다면 이동
				if(map[x][y+dy[dir]] == '.') {
					map[x][y] = '.';
					y+= dy[dir];
				}
				map[x][y] = '<';
				//showState(cmd);

				break;
			case 'R':
				dir = 1;
				if( y+dy[dir] < 0 || y+dy[dir] >= w) {
					map[x][y] = '>';
					break;
				}
				if(map[x][y+dy[dir]] == '.') {
					map[x][y] = '.';
					y+= dy[dir];
				}
				map[x][y] = '>';
				//showState(cmd);

				break;
			case 'U':
				dir = 0;		
				if( x+dx[dir] < 0 || x+dx[dir] >= h) {
					map[x][y] = '^';
					break;
				}
				if(map[x+dx[dir]][y] == '.') {
					map[x][y] = '.';
					x+= dx[dir];
				}
				map[x][y] = '^';		
				//showState(cmd);
				break;
			case 'D':
				dir = 2; // 방향돌림 
				map[x][y] = 'v'; 
				if( x+dx[dir] < 0 || x+dx[dir] >= h) {
					map[x][y] = 'v';
					break;
				}
				if(map[x+dx[dir]][y] == '.') {
					map[x][y] = '.';
					x+= dx[dir];
				}
				map[x][y] = 'v'; 
				//showState(cmd);
				break;
		}
		
	}

	private static void showState(char cmd) {
		System.out.println();
		System.out.println("now cmd -> "+cmd +" now dir -> "+dir);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}