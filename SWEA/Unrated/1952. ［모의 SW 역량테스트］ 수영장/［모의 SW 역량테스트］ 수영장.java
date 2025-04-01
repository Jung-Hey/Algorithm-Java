import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 *  kb
 *  ms
 */
public class Solution {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			int[] price = Arrays.stream(br.readLine().split(" "))
				        		.mapToInt(Integer::parseInt).toArray();		
			int [] month = IntStream.concat(IntStream.of(0),
			        Arrays.stream(br.readLine().split(" "))
	        		.mapToInt(Integer::parseInt)).toArray();
			// 가장 높은 요금
			int answer = Arrays.stream(price).max().getAsInt();
			// dy :  dy[x]는 0 ~ x월까지의 최소 수영장 이용 가격 
			int [] dy = new int[12+1];
			for (int i = 1; i <= 12; i++) {
				// 1일권과 1개월 권 계산의 비교 
				dy[i] = Math.min(dy[i-1] + month[i]*price[0], dy[i-1] + price[1]);
				// 3개월 권의 비교
				if(i >= 3) {
					dy[i] = Math.min(dy[i] , dy[i-3]+price[2]);
				}
			}
			answer = Math.min(answer, dy[12]);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		//output
		System.out.println(sb);
	
		
	}


}
