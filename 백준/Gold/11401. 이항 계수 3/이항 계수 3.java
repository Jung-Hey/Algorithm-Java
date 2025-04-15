import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *   kb
 *   ms
 *  페르마 소정리
 */
public class Main {

	// 
	static long [] facto;
	static int MOD = 1_000_000_007;
    public static void main(String[] args) throws NumberFormatException, IOException {
    
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
    	// 펙토리얼 초기화
    	facto = new long[n+1];
    	facto[0] = facto[1] = 1; 
    	for (int i = 2; i <= n; i++) {
    		facto[i] = (i * facto[i-1]) % MOD;
		}
    	
    	// 
    	long res = nCk(n,k);
    	System.out.println(res);
//    	System.out.println(power(4,2));
    	 
    	
    	
    	
    
    }
	private static long nCk(int n, int k) {
		long res = 0;
		// 분자
		res = facto[n];
		
		// 분모
		res *= power( facto[n-k]*facto[k]%MOD  , MOD - 2 );
		return res %= MOD;
	}
	
	// x는 밑 y는 지수
	private static long power(long x, int y) {
		if(y==0) return 1;
		long num = power(x, y/2);
		long result = num * num % MOD;
		//System.out.println("x = "+x +" y = "+y +" num= "+num + " result = "+result);
		if(y%2==1) result = result*x % MOD;
		return result;

		// 4 0 num(1) res(1)
		// 4 1 num(1) res(4)
		// 4 2
		
	}


}
