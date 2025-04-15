import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *  kb
 *  ms
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
		
		System.out.print(GCD(a,b)+" "+LCM(a,b));
    }

    // 최대공약수 : 유클리드 호제
	private static int GCD(int a, int b) {
		if(a%b == 0) return b;
		else return GCD(b, a%b);
	}
	
	// 최소공배수
	private static int LCM(int a, int b) {
		return a*b / GCD(a,b);
	}
}
