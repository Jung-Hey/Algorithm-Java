import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 14502. 연구소 
 * 
 * <p> Time: 788 ms, Memory: 149668 KB </p> 
 * @author JungHyeon Heo
 */

public class Main {
	

	static int n,m,answer;
	static char [][] arr;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static boolean[] alpa;
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = 0;
		arr = new char[n][m];
		alpa = new boolean[26];
		// solve
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		//System.out.println(1 << (int)'B'-65); // 2
		dfs(0,0,1);
		// out
		System.out.println(answer);
	
	}

	private static void dfs(int x, int y, int moveCnt) {
		alpa[(int)arr[x][y]-'A'] = true;
		answer = Math.max(answer, moveCnt);

		for (int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			int next = (int)arr[nx][ny] - 'A';
			if(alpa[next]) continue;
			alpa[next] = true;
			dfs(nx, ny , moveCnt+1);
			alpa[next] = false;
		}


	}



}