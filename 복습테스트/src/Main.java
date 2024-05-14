//import java.util.*;
//public class Main {
//    static int ans;
//    static int[][][] memo; //자리수, 직전수, 마스킹
//    final static int MOD = 1000000000;
//    static public int twist(int idx, int pre, int ck) {
//        if(idx < 1) {
//            if(ck != ans) return 0;
//            return 1;
//        }
//        if(memo[idx][pre][ck] == -1) {
//            int sum = 0;
//            if(pre - 1 >= 0) sum += twist(idx - 1, pre-1, (ck | (1 << (pre-1))));
//            if(pre + 1 < 10) sum += twist(idx - 1, pre+1, (ck | (1 << (pre+1))));
//            memo[idx][pre][ck] = sum % MOD;
//        }
//        return memo[idx][pre][ck];
//    }
//
//    public static void main(String[] args)  {
//        Main M = new Main();
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();// 12
//        memo = new int[len][10][1024];
//        for(int i = 0; i < len; i++) {
//            for (int j = 0; j < 10; j++) {
//                Arrays.fill(memo[i][j], -1);
//            }
//        }
//        ans = 1;
//        ans = (ans << 10) - 1;// 1023
//        int cnt = 0;
//        for(int i = 1; i < 10; i++) {
//            cnt += M.twist(len - 1, i, 1 << i);
//            System.out.println("i : "+i +" "+ (1 << i) + " "+ cnt );
//            cnt %= MOD;
//        }
//        System.out.println("#"  + cnt);
//    }
//}
//
//
//

import java.util.*;
public class Main {

    final static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] dp = new long[N + 1][10]; // [자릿수][자리값]
        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }
        // 두 번째 자릿수부터 N까지 탐색
        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
               if(j==0){ // 0 은 1밖에 없음
                   dp[i][j] = dp[i-1][1] % mod;
               }
               else if(j==9){ // 0 은 1밖에 없음
                    dp[i][j] = dp[i-1][8] % mod ;
               }
               else{
                   dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
               }
            }
        }
        long res = 0L;
        for(long r : dp[N]){
            res+=r;
        }
        System.out.println(res%mod);
    }
}