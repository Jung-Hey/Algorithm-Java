import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = Stream.concat(Stream.of(0), 
										Arrays.stream(br.readLine().split(" "))
												.map(Integer::parseInt))
												.mapToInt(i -> i).toArray();
		/**
		 * dy [i][j] = i번째에서 j번째 문자까지 팰린드롬을 만들기 위해 추가해야 하는 최소 문자
		 * dy [1][1] = (최소) 첫번째 문자를 팰린드롬으로 만들기 위해 추가되어야 하는 최소 문자는 0. [2][2]...[n][n] 동일
  		 */
		int [][] dy = new int[n+1][n+1]; // 
		
		/**
		 * 1. 한글자부터 두글자 세글자 ... n글자까지 최소 팰린드롬에 필요한 최소 추가횟수를 추가해나감
		 * 2. 네글자를 예로 든다. 가장 첫자리와 끝자리에 따라 구하는 값이 달라진다 
		 * 	2-1(같을때) [2 3 5 2] -> 두번째~세번째에 필요한 팰린드롬의 추가 횟수가 정답이다. -> dy[1][4] == dy[2][3]
		 * 	2-2(다를때) [2 3 5 1] -> 팰린드롬을 만들기 위해 첫번째에서 세번째 값 +1 이나  두번째값 + 네번째 값 + 1 한다
		 *  왜냐하면 [2 3 5 1]을 -> [2 3 5 1 5 3 2] 로 만들 수도 있고 [1 5 2 3 2 5 1]로도 만들 수 있기때문에
		 *  작은 dy[1][3] 과 dy[2][4] 중 작은 값 + 1 이 dy[1][4] 의 정답이 된다.
		 */
		
		// 아래 반복문은 이런식으로 두글자 세글자 네글자 마지막으로는 시작~끝 글짜까지 필요한 인덱스 접근
		// 1 2
		// 2 3
		// 3 4
		// 4 5
		
		// 1 3
		// 2 4
		// 3 5
		
		// 1 4
		// 2 5
		
		// 1 5
	    for(int i=1; i<n;i++){
            for(int j=i+1; j<=n;j++){
            	int start = j-i;
            	int end = j;
            	// 시작글자와 끝글자가 같으면
                if(arr[start] == arr[end]){
                    dy[start][end] = dy[start+1][end-1];
                }
				// 시작글자와 끝글자가 다르면 
                else {
                	dy[j-i][j] = Math.min( dy[start+1][j], dy[start][end-1] ) + 1;
                }
            }
        }
		System.out.println(dy[1][n]);
		

		
		
    }
}
   