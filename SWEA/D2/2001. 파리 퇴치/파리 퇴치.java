import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 32,896 kb
 * 162 ms
 * 2차원 누적합 배열을 이용해 이중 반복문을 돌며 m*m 크기만큼에 합에 해당하는 값을 
 * 최대값 갱신을 반복
 */
class Solution
{
    static int[][] arr;
    static int[][] sumArr;
    static int m,n;
    
    public static int solveMax() {
        // 누적합을 저장해 놓기 위한 배열에 저장
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
            	/*
            	 *   누적합[i][j] = 
            	 *   	기존배열[i-1][j-1] (원래 배열에 해당하는 더할 값) + (누적합배열 x축 -1 + y축 -1 값 ) - sumArr[i-1][j-1](겹치는 부분)
            	 */
                sumArr[i][j]= arr[i-1][j-1] + sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] ;
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
            arr = new int[n][n];
             // 누적합 배열
        	sumArr = new int[n + 1][n + 1];
            for(int i=0;i<n;i++){
               arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
          	// solve
            sb.append("#").append(t).append(" ").append(solveMax()).append("\n");
		}
		System.out.println(sb);
		
		
	}
}