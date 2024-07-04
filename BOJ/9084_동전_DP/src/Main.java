import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        //테스트케이스
        for(int i=0; i<t;i++) {
            int n = sc.nextInt();
            int[] coins = new int[n+1];
            for (int j = 1; j <= n; j++) coins[j] = sc.nextInt();
            int target = sc.nextInt();
            int [] dp = new int[target+1];
            //동전 종류
            for(int j=1; j<=n; j++){
                // dp[k] : 동전을 사용해 k원 으로 만들 수 있는 경우의 수
                for(int k=1; k<=target; k++){
                    if(k-coins[j] > 0){
                        dp[k] = dp[k] + dp[k-coins[j]];
                    }
                    else if(k-coins[j]==0) dp[k]++;
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}