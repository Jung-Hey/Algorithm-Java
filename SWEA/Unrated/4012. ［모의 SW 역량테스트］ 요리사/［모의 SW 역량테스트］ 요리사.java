import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int n,b,ans;
	static StringBuilder sb;
	
	static int[][] arr;
	static int[] combi;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), t = 0;
		sb = new StringBuilder();
		while(t++ < tc) {
			ans=Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine()); 
			combi = new int[n/2];
			arr = new int [n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			//dfs(0,0);
			dfs(1,1);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void dfs(int l, int start) {
		if(l == (n/2)) {	
			//System.out.println(Arrays.toString(combi));
			getMinDiff();
		}
		else {
			for (int i = start; i < n; i++) {
				combi[l] = i;
				dfs(l+1, i+1);
			}
		}
	}


	private static void getMinDiff() {
		int aTotal=0, bTotal=0;
		Set<Integer> A = new HashSet<>();
		for(Integer cb : combi) A.add(cb);
		// A 먼저 구함 A(A음식을 만들 수 있는 식재료들)에서 2개만큼 뽑음. 반복문 이용 
		for(int i=0; i<n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(i==j)continue;
				int x = combi[i], y = combi[j];
				aTotal += arr[x][y];
			}
		}
		// B를 구함 (A의 반대)
		int [] bCombi = new int[n];
		for(int i=0;i<n;i++) bCombi[i]=i;
		bCombi=Arrays.stream(bCombi).filter(b -> !A.contains(b)).toArray();
		for(int i=0; i<n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(i==j)continue;
				int x = bCombi[i], y = bCombi[j];
				bTotal += arr[x][y];
			}
		}
		//
		
		
		ans = Math.min(ans, Math.abs(aTotal-bTotal));
		
	}
	

}