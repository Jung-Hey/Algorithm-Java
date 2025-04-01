import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *  kb
 *  ms
 */
public class Solution {
	static StringBuilder sb;
	static List<Integer> useList;
	static int answer;
	static int[]  price;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			
			price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int [] m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 가장 높은 요금
			answer = Arrays.stream(price).max().getAsInt();
			//answer = Math.max(price[3], price[2]*4);
			
			useList = new ArrayList<>();
			for(int day : m) {
				if(day > 0) useList.add(day);
			}

			if(useList.size() > 0) dfs(0,0);
			else answer=0;
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		//output
		System.out.println(sb);
	
		
	}
	

	private static void dfs(int l, int sum) {
		if(sum > answer) return;
		if(l >= useList.size()) {
			answer = Math.min(answer, sum);
		}
		else {
			// 1일치로 계산
			dfs(l+1, sum+price[0]*useList.get(l));
			// 1달로 계산
			dfs(l+1, sum+price[1]);
			// 3달로 계산
			dfs(l+3, sum+price[2]);
		}
	}




}
