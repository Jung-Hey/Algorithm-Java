import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 15916 kb
 * 124 ms
 * 15650번
 * 
 * 뽑을 수가 3이 고정이기 때문에 반복문 이용 
 * 배열 오름차순 정렬 후 카드 3개의 합이 최대치 넘어가면 break;
 */
class Main
{
    
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer=0;
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n; j++) {
        		for(int k=j+1; k<n; k++) {
        			int sum = arr[i]+arr[j]+arr[k];
                	if(sum > target) {
                		break;
                	}
                	else answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
		
	}

	
}