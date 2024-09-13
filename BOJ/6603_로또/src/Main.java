import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
class Main {
    static int[] S;
    static int[] pm;
    static StringBuilder sb;
    static Integer n;
    static void dfs(int l , int start) {
        if(l == 6){
            for (int j : pm) {
                sb.append(S[j]+" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for (int i = start; i < n; i++) {
                pm[l] = i;
                dfs(l+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // n개의 숫자
            pm = new int[6];
            if(n==0){
                break;
            }
            S = new int[n];
            for(int i = 0; i < n; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");

        }
        System.out.println(sb);
    }
}