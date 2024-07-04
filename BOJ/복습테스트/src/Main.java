import java.util.*;

class Main {
    static int n,d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        // 테스트케이스 만큼 반복
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] coins = new int[n];
            for(int j=0; j<n; j++) coins[j] = sc.nextInt();
            int target = sc.nextInt();
            int[] dp = new int[target+1];
            //dp
            for(int k = 0; k<n; k++){ // 동전 종류
                for(int l = 1; l<=target; l++){ // 각 l원 마다 만들 수 있는 동전 수
                    if( l - coins[k] > 0 ){
                        dp[l] = dp[l] + dp[l- coins[k]];
                    }
                    else if( l - coins[k] == 0 ){
                        dp[l]++;
                    }
                }
                System.out.println(Arrays.toString(dp));
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}