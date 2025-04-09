import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int [][] arr;
	static StringBuilder sb;
	static int n;
	static final int INF = 10000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	// input
        	n = Integer.parseInt(st.nextToken());
        	arr = new int[n][n];
        	for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = Integer.parseInt(st.nextToken()) == 1 ? 1 : INF;
					if(i==j) continue; // 자기는 못감
					arr[i][j] = r;
				}
			}
        	//solve
        	for (int k = 0; k < n; k++) {
        		for (int i = 0; i < n; i++) {
        			if(k==i) continue;
        			for (int j = 0; j < n; j++) {
        				if(i==j) continue;
        				if(k==j) continue;
        				arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
        				
        			}
        			
    			}
			}
        	int answer=INF;
        	for (int i = 0; i < n; i++) {
        		answer = Math.min(answer, Arrays.stream(arr[i]).sum());
        	}
        	
        	sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }	
        
        
        // output
        System.out.println(sb);
		
	}
}
