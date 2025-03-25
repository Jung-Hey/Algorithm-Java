import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] dy = new int[n+1];
		int [] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		// dy[m] 은 m번째 밟은 계단의 최대 점수 누적  
		dy[1] = arr[1];
		// 2번째 밟은 계단은 첫번째 계단과 두 번째 계단의 점수의 합
		if(n > 1) dy[2] = arr[1] + arr[2];
		for (int i = 3; i <= n; i++) {
			// 
			dy[i] = Math.max(dy[i-2]+arr[i], dy[i-3]+arr[i-1]+ arr[i]);
		}
		
		// output
		System.out.println(dy[n]);
		
	}
}