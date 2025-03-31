import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 117416kb
 * 460 ms
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = str.length();
		int [] dy = new int[len+1]; // 1 ~ x 까지의 최소 팰린드롬 분할 수
		boolean [][] minPal = new boolean[len+1][len+1]; // [i] ~ [j] 문자열의 팰린드롬 여부
		 // 길이가 1인 문자는 무조건 팰린드롬이다.
        for(int i=1; i<=str.length(); i++){
        	minPal[i][i] = true;
        }
        // 처음 시작의 최소 팰린드롬 분할의 개수는 1
		dy[1]=1;
		for (int i = 2; i <= len ; i++) {
			// 이전 팰린드롬 분할 개수의 + 1 값 [1]인 문자열의 최소 팰린드롬 수는 1개 [1, 2] 일경우에는 2개 이런식으로 증가
			int min = dy[i-1] + 1;
			for (int j = 1; j <i ; j++) {
				// 두 탐색지점이 같으면
				if(str.charAt(j-1) == str.charAt(i-1)){
					/**
					 * 양 쪽이 같을때 아래 두가지 경우를 고려
					 * 1. j+1 == i -> AA 와 같은 문자열
					 * 2. minPal[j+1][i-1] -> ABBA 일때 양끝의 A가 같으니 BB만 비교한다 즉 minPal[2][3]이 팰린드롬이면 
					 * 	  minPal[1][4] 도 팰린드롬
					 */
					if(j+1 == i || minPal[j+1][i-1]){
						minPal[j][i] = true;
						min = Math.min(min, dy[j-1]+1);
					}
				}
			}
			dy[i] = min;
		}
		//output
		System.out.println(dy[len]);
		

		
		
    }
}
