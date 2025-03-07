import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 14502. 연구소 
 * 
 * <p> Time: 788 ms, Memory: 149668 KB </p> 
 * @author JungHyeon Heo
 */

public class Main {
	

	static int n,m,answer;
	static int [][] arr;
	static ArrayList<int[]> list;
	static ArrayList<int[]> virus;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = 0;
		list = new ArrayList<>();
		virus = new ArrayList<>();
		arr = new int[n][m];
		// solve
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 0) list.add(new int[] {i,j});
				else if(arr[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		dfs(0,0);
		// out
		System.out.println(answer);
	
	}

	
	private static void dfs(int l, int start) {
		if(l == 3) {
			// 완성된 조합을 토대로 최대 안전 영역 크기 구함 
			getMaxSafeArea();
		}
		else {
			for (int i = start; i < list.size(); i++) {
				int [] wall = list.get(i);
				arr[wall[0]][wall[1]] = 1;
				dfs(l+1, i+1);
				arr[wall[0]][wall[1]] = 0;
			}
		}
	}

	private static void getMaxSafeArea() {
		// 바이러스 원본 저장
		Queue<int[]> q = new LinkedList<>();
		for(int [] v : virus) q.offer(v);
		// 배열 복사
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}
		// 최대 안전 영역 구하기
		while(!q.isEmpty()) {
			int len = q.size();
			int [] nowVirus = q.poll();
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 4; j++) {
					int nx = nowVirus[0] + dx[j];
					int ny = nowVirus[1] + dy[j];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(temp[nx][ny] == 0) {
						temp[nx][ny] = 2;// 바이러스화 시킴
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		// 남은 안전구역 세기
		int safeAreaCount=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(temp[i][j] == 0) safeAreaCount++;
			}
		}
		answer = Math.max(answer, safeAreaCount);
	}

}