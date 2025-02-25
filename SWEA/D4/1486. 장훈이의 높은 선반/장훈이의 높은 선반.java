import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n,b,ans;
	static StringBuilder sb;
	static int[] arr;
	static boolean [] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), t = 0;
		sb = new StringBuilder();
		
		while(t++ < tc) {
			ans=Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //점원의 수
			b = Integer.parseInt(st.nextToken()); // 높이 
			isVisited = new boolean[n];
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dfs2(0, 0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int l, int sum) {
		if(sum-b > ans) return; // 점원들의 키의 합과 선반 높이의 차가 최소값 갱신한 것 보다 높으면 리턴
		if(l==n) {
			int tmp = sum-b; 
			if(tmp >= 0) ans = Math.min(ans, tmp);
		}
		else {
			dfs(l+1, sum+arr[l]);
			dfs(l+1, sum);
		}
	}
	
	
	private static void dfs2(int l, int sum) {
		//if(sum-b > ans) return; // 점원들의 키의 합과 선반 높이의 차가 최소값 갱신한 것 보다 높으면 리턴
		if(sum >= b) {
			ans = Math.min(ans,  sum-b);
		}
		else {
			for (int i = l; i < n; i++) {
				sum+=arr[i];
				dfs(i+1, sum);
				sum-=arr[i];
			}
		}
	}
	
	

}