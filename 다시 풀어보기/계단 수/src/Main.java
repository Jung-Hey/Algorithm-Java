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
        // 계단 수 ( 0~9 들어가는지 체크)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] dp = new long[n+1][10][1<<10]; // 1<<10 = 1024
        // 1<<i : 0~9 비트마스킹
        for(int i=1; i<10; i++) {
            dp[1][i][1<<i] =1;
            System.out.println(i+" "+ (1<<i) );
        }
        // 2 ~ n 자리까지
        for(int i=2; i<=n; i++) {
            // j(로 끝나는 수) 0 ~ 9
            for(int j=0; j<10; j++) {
                for(int k=0; k<1024; k++) {
                    int bit = k | (1 << j);
                    if(j==0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][1][k]) % mod;
                    }
                    else if(j==9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][8][k]) % mod;
                    }
                    else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]+ dp[i-1][j-1][k]) % mod;
                    }
                }
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++) {
            System.out.print(dp[n][i][1023]+" ");
            sum = (sum + dp[n][i][1023]) % mod;
        }
        System.out.println();
        System.out.println(sum);




    }
}