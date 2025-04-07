import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *  25491 KB
 *  360 ms
 */
public class Main {
	
	static char [][] arr;
	static int answer;
	static int [] pm;
    public static void main(String[] args) throws NumberFormatException, IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();	
		}
		// solve
		pm = new int[7];
		dfs(0, 0, 0);

		// output
		System.out.println(answer);
		
    }

	private static void dfs(int l, int start, int limCount) {
		if(limCount > 3) return;
		if(l == 7) {
			makePrincess();
		}
		else {
			for (int i = start; i < 25; i++) {
				pm[l] = i;
				dfs(l+1, i+1, isLim(pm[l]) ? limCount+1:limCount);
			}
		}
		
	}

	private static boolean isLim(int idx) {
		int x = idx / 5;
		int y = idx % 5;
		return arr[x][y] == 'Y';
		
	}

	private static void makePrincess() {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		boolean [][] isSelected = new boolean[5][5];
		boolean [][] isVisited = new boolean[5][5];
		
		for(int idx : pm) {
			int x = idx / 5;
			int y = idx % 5;
			isSelected[x][y] = true; // 선택한거 방문처리
		}

		int sx = pm[0] / 5;
		int sy = pm[0] % 5;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		
		int len = 1;
		isVisited[sx][sy] = true; 
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || nx >=5 || ny < 0 || ny >=5) continue;
				// 선택되지 않으면 넘어감
				if(!isSelected[nx][ny]) continue;
				// 방문처리
				if(isVisited[nx][ny]) continue;
				isVisited[nx][ny] = true;
				
				q.offer(new int[] {nx,ny});
				len++; // 연결된 길이 증가
			}
		}
		if(len == 7) answer++;
		
	}
	

}

