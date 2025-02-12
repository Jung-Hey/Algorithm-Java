import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] pm;
	static int[] ch;
	static int res;
	static int[][] arr;
	static List<int[]> spinList;
	static int n,m;
	
	private static void spin(int[][] spinArr, int x1, int y1, int x2, int y2) {
        while (x1 < x2 && y1 < y2) {
            int next = spinArr[x1][y1]; // 다음에 넣어줄 값
            int now = 0; // 현재 값

            // 오른쪽
            for (int i = y1 + 1; i <= y2; i++) {
                now = spinArr[x1][i]; 
                spinArr[x1][i] = next;
                next = now;
            }
            
            // 아래
            for (int i = x1 + 1; i <= x2; i++) {
                now = spinArr[i][y2];
                spinArr[i][y2] = next;
                next = now;
            }

            // 왼쪽
            for (int i = y2 - 1; i >= y1; i--) {
                now = spinArr[x2][i];
                spinArr[x2][i] = next;
                next = now;
            }

            // 위
            for (int i = x2 - 1; i >= x1; i--) {
                now = spinArr[i][y1];
                spinArr[i][y1] = next;
                next = now;
            }

            x1++;
            y1++;
            x2--;
            y2--;
        }
		

		
		
	}
	
	private static void getMinArray() {
		int [][] spinArr = new int[n][m];
		//깊은 복사
		for (int i = 0; i < spinArr.length; i++) {
			spinArr[i] = arr[i].clone();
		}
		// 변수 idx 가 중복되지 않는 순열 pm을 순회 
		for(int idx : pm) {
			int[] spinInfo = spinList.get(idx);
			// 배열 돌리기
	        int r = spinInfo[0]-1;
	        int c = spinInfo[1]-1;
	        int s = spinInfo[2];

	        // **배열 범위를 넘어서는 경우, 유효한 범위로 조정**
	        int x1 = r - s;
            int y1 = c - s;
            int x2 = r + s;
            int y2 = c + s;

	        // 배열 돌리기
	        spin(spinArr, x1, y1, x2, y2);

		}		
		for (int i = 0; i < n; i++) {
			int minTmp = Arrays.stream(spinArr[i]).sum();
			res = Math.min(res, minTmp);
		}
	}
	
	private static void dfs(int level , int k) {
		if(level == k) {
			getMinArray();
			return;
		}
		else {
			for (int i = 0; i < k; i++) {
				if(ch[i]==0) {
					ch[i]=1;
					pm[level]=i;
					dfs(level+1, k);
					ch[i]=0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		res=Integer.MAX_VALUE;
		// input
		n = Integer.parseInt(st.nextToken()); // 배열 세로
		m = Integer.parseInt(st.nextToken()); // 배열 가로
		int k = Integer.parseInt(st.nextToken()); // 회전 연산의 수 
		
		spinList = new ArrayList<>();
		arr = new int[n][m];
		pm = new int[k];
		ch = new int[k];
		// 배열 정보 저장 
		for (int i = 0; i < n; i++) { 
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 회전 정보 저장
		for (int i = 0; i < k; i++) { 
			int[] spin = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			spinList.add(spin);
		}
		// 
		dfs(0,k);
		System.out.println(res);
    }

	
	
}

//