import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [] dx = {-1,0,1};
	static int n,m;
	static char [][] arr;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			dfs(i,0);
		}
		System.out.println(answer);
	}
	private static boolean dfs(int x, int y) {
		if(y == m-1) {
			if(arr[x][y] == '.') {
				answer++; // 도착
				arr[x][y] = '*';
				//print();
				return true;
			}
			
			
		}
		else {
			arr[x][y] = '*';
			for (int i = 0; i < dx.length; i++) {
				// 3방
				int nx = x + dx[i];
				int ny = y + 1;
				if(nx<0 || nx>=n || ny >= m) continue;
				if(arr[nx][ny] != '.') continue;
				// 선 하나라도 연결되면 그 이전은 더 뻗어나가면 안됨
				if(dfs(nx, y+1)) return true; 
			}
		}
		return false;
		
	}
	private static void print() {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
}