import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] unf;
	static StringBuilder sb;
	
	static int find(int v) {;
		if(v == unf[v]) return v;
		else return unf[v] = find(unf[v]);
	}
	
	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa != fb) unf[fa] = fb;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			unf = new int[n+1];
			// Make-set
			for (int i = 1; i <= n; i++) unf[i]=i;
			int m = Integer.parseInt(st.nextToken());
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(type == 1) { // find
					int fa = find(a);
					int fb = find(b);
					sb.append(fa==fb?1:0);
				}
				else { // union
					union(a, b);
				}
			}
			sb.append("\n");
		}
		//output
		System.out.println(sb);
	
		
	}

}
