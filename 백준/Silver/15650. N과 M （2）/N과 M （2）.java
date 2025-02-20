import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**

 */
class Main
{
    static int[] arr;
    static int[] pm;
    static int n,m;

	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) arr[i]=i;
        pm = new int[m];
       
        // solve
        dfs(0,1);
    
		
	}

	private static void dfs(int level, int start) {	
		if(level == m) {
			for(int p : pm) {
				System.out.print(p+" ");
			}
			System.out.println();
		}
		else {
			for (int i = start; i <= n; i++) {
				pm[level] = arr[i];
				dfs(level+1, i+1);
			}
		}
	}
}