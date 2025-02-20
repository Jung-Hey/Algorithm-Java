import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
    static int[][] arr;
    static int[][] sumArr;
    static int m,n;
    
    public static int solveMax() {
        // 누적합을 저장해 놓기 위한 배열에 저장
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sumArr[i][j]= arr[i-1][j-1]+ sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] ;
            }
        }
        //만들어진 누적합으로 m에 따른 계산
        int maxSum = Integer.MIN_VALUE;
        for(int i=m; i<=n; i++){
            for(int j=m; j<=n; j++){
                int sum = sumArr[i][j] - sumArr[i-m][j] - sumArr[i][j-m] + sumArr[i-m][j-m];
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		
		int tc= Integer.parseInt(br.readLine()) , t=0;

		while(t++ < tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int answer=0;
            arr = new int[n][n];
             // 누적합 배열
        	sumArr = new int[n + 1][n + 1];
            for(int i=0;i<n;i++){
               arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            
          	//누적합
            sb.append("#").append(t).append(" ").append(solveMax()).append("\n");
		}
		System.out.println(sb);
		
		
	}
}