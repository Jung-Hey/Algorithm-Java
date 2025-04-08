import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 */
public class Solution {
 
    
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = getLis(arr,n);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

	private static int getLis(int[] arr, int n) {
		// dy [i] : i번째를 끝으로 하는 최장 증가 부분 수열의 길이 
		int [] dy = new int[n];
		dy[0] = 1;
		int res = 0;
		// solve
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					max = Math.max(max, dy[j]);
				}
			}
			dy[i] = max+1;
			res = Math.max(res, dy[i]);
		}
		
		return res;
	}
 
 
 

 
}