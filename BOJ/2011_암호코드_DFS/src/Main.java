/**
 * DFS , 메모이제이션
 */
import java.util.*;
class Main {
    static String s;
    static long[] dy;
    static long div =1000000L;
    public static long dfs(int l){
        if(dy[l] > 0) return dy[l];
        if(l<s.length() && s.charAt(l)=='0') return 0;
        if(l>=s.length()-1) return 1;
        else{
            long res = dfs(l+1) % div;
            long tmp = Integer.parseInt(s.substring(l,l+2));
            if(tmp <= 26) res += dfs(l+2);
            return dy[l]= res % div;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        dy= new long[100001];
        long answer = dfs(0);
        answer = answer % div;
        System.out.println(answer);
    }
}
