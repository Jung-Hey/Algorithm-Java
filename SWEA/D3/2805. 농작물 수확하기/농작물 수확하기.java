import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), t=0;
		StringBuilder sb = new StringBuilder();
		while(t++<tc) {
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
			int [][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			// solve
			int startIdx = n/2; // 시작 위치
			int rowIdx=0; // row 인덱스번호
			int rc = 1; // 반복 횟수
			// 절반 row 까지  계산
			while(rc <= n) {
				for(int i=startIdx; i<startIdx+rc; i++) {
					answer += arr[rowIdx][i];
				}
				rc+=2;
				rowIdx++;
				startIdx--;
			}
			// 나머지 계산
			startIdx = 1;
			rowIdx = n/2 + 1;
			rc = n-2;
			while(rc >= 1) {
				for(int i=startIdx; i<startIdx+rc; i++) {
					answer += arr[rowIdx][i];
				}
				rc-=2;
				rowIdx++;
				startIdx++;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}