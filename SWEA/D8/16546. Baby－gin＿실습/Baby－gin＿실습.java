import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	static int [] pm;
	static int [] ch;
	static int [] arr;
	static String str="";
	static boolean pass;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), t=0;
		while(++t <= tc) {
			pass = false;
			str = br.readLine();
			arr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
			pm = new int[6];
			ch = new int[6];
			dfs(0);
			sb.append("#").append(t).append(" ").append(pass).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int l) {
		if(l == 6) {
			solve();
		}
		else {
			for (int i = 0; i < 6; i++) {
				if(ch[i]==0) {
					ch[i]=1;
					pm[l]=i;
					dfs(l+1);
					ch[i]=0;
				}
				
			}
		}
		
	}

	private static void solve() {
		int one = arr[pm[0]];
		int two = arr[pm[1]];
		int three = arr[pm[2]];
		
		if(one - two == -1) {
			if(two - three != -1) {
				return;
			}
		}
		else if(one == two) {
			if(two != three) {
				return;			}
		}
		else {
			return;
		}		
		 one = arr[pm[3]];
		 two = arr[pm[4]];
		 three = arr[pm[5]];
		
		if(one - two == -1) {
			if(two - three != -1) {
				return;
			}
		}
		else if(one == two) {
			if(two != three) {
				return;
			}
		}
		else {
			return;
		}
		
        pass = true;
		
		
	}

}