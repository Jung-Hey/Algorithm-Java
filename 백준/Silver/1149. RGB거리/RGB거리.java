import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int n = Integer.parseInt(br.readLine());
		  int [][] arr = new int[n+1][3];
	      int [] dr = new int[n+1];
	      int [] dg = new int[n+1];
	      int [] db = new int[n+1];
	        

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 각 집을 칠하기 위한 비용 입력
            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }
        for (int i = 1; i <= n; i++) {
        	// RGB 각각의 시나리오 i는 자기층을 각각의 색으로 색칠.
        	// 자기층-1 은 자기색 말고 남은 두 색으로 칠할 수 있는데 그 중 작은 비용으로 색칠
        	dr[i] = Math.min(dg[i-1], db[i-1]) + arr[i][0];
        	dg[i] = Math.min(dr[i-1], db[i-1]) + arr[i][1];
        	db[i] = Math.min(dr[i-1], dg[i-1]) + arr[i][2];
		}
        int answer = Math.min(dr[n], dg[n]);
        answer = Math.min(answer, db[n]);
        System.out.println(answer);
      
   
        
        
		
	}

}
