import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 10026. 적록색약 
 * 
 * <p> Time: 140 ms, Memory: 17188 KB </p> 
 * @author JungHyeon Heo
 */

public class Main {
	
	static char[][] arr;
	static int n, jungSang, bJungSang;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char [n][n];
		// solve
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 최초 구역은 세면서 R과 G는 ->'*'로 변경. B는 -> '.' 로 변경
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] != '*' &&  arr[i][j] != '.') {
					jungSang++; // 정상인이 보는 구역 ++
					fill(arr[i][j], i, j, true);
				}
			}
		}
		// 2번째 적록색약에 대해서는 '*'든 '.'든 -> '_' 로 변경
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] != '_') {
					bJungSang++; // 비정상인이 보는 구역 ++
					fill(arr[i][j], i, j, false);
				}
			}
		}
		// out
		System.out.println(jungSang+" "+bJungSang);
	}
	private static void fill(char target, int x, int y, boolean isJungSang) {
		char to;
		if(isJungSang) to = (target  == 'R' || target == 'G') ? '*' : '.';
		else to = '_';
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {x,y});
		arr[x][y] = to;
		while(!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int [] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(arr[nx][ny] == target) {
						arr[nx][ny] = to;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
	


}