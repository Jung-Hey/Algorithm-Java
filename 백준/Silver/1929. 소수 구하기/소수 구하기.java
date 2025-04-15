import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *   kb
 *   ms
 *   에라토스테네스의 체
 */
public class Main {

	// m ~ n 까지의 소수 출력 
    public static void main(String[] args) throws NumberFormatException, IOException {
    
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	int m = sc.nextInt();
    	int n = sc.nextInt();
    	
    	boolean [] arr = new boolean[n+1];
    	for (int i = 2; i <= n; i++) {
			if(!arr[i]) {
				if(i >= m) sb.append(i).append("\n");
				for (int j = i; j <= n; j+=i) {
					arr[j] = true;
				}
			}
		}
    	// output
    	System.out.println(sb);
    }


}
