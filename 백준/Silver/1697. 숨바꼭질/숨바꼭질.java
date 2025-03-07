import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 2178. 미로탐색
 * 
 * <p> Time: 164 ms, Memory: 16928 KB </p> 
 * @author JungHyeon Heo
 */

public class Main {
	
	static int n,k;
	static int[] dy = {-1,1};
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// solve
		System.out.println(bfs());;
	}

	private static int bfs() {
		int bg = Math.max(n, k)+1;
		boolean [] visited = new boolean[bg+1];	
		visited[n] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		int level = 0;
		//bfs
		while(!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int now = q.poll();
				if(now == k) return level;
				if(now+1 <= bg  && !visited[now+1]) {
					visited[now+1] = true;
					q.offer(now+1);
				}
				if(now-1 >= 0 && !visited[now-1]) {
					visited[now-1] = true;
					q.offer(now-1);

				}
				if(now*2 <= bg && !visited[now*2]) {
					visited[now*2] = true;
					q.offer(now*2);

				}
			}
			level++;
		}
		
		System.out.println("end");
		return level;
	}
}