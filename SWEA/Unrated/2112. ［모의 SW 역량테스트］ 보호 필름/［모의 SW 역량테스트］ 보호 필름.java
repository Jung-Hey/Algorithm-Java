import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int d,w, k;
    static int [][] arr;
    static int answer;
    static int[] A = new int[20];	//A투입 시 참조할 배열
    static int[] B = {1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine()), t=0;
        while (t++<tc){
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = Integer.MAX_VALUE;
            d = Integer.parseInt(st.nextToken()); // 두께
            w = Integer.parseInt(st.nextToken()); // 가로사이즈
            k = Integer.parseInt(st.nextToken()); // 통과기준
            arr = new int[d][w];
           // arr = new int[13][20];
            for (int i=0; i<d; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            if( k > 1) {
            	for (int i = 0; i <= k; i++) {
            		// i개 사용한다 가정하고 조합 
					if(dfs(0,0,i)) {
						answer = i;
						break;
					}
				}
            }
            else answer = 0;

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    
    private static boolean dfs(int l, int start, int cnt) {
    	// cnt개의 조합 완성
    	if(l == cnt) {
    		if(checkFilm()) return true;
    	}
    	else {
    		for(int i = start; i<d; i++) {
    			int [] temp = arr[i];
    			
    			arr[i] = A;
    			if(dfs(l+1, i+1, cnt)) return true;

    			arr[i] = B;
    			if(dfs(l+1, i+1, cnt)) return true;
    			
    			arr[i] = temp;

    		}
    	}
    	return false;
    }

    private static boolean checkFilm() {
        A:for (int i = 0; i < w; i++) {
            int tmp = 1; // 연속된 길이
            for (int j = 1; j < d; j++) {
                if(arr[j][i] == arr[j-1][i]) {
                    if(++tmp == k) break;
                }
                else tmp=1;
            }
            if(tmp < k) return false;
        }
        return true;



    }
}