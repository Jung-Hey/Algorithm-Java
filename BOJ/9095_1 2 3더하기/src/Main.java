import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb= new StringBuilder();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1]+ dp[i-2]+dp[i-3];
        }
        while (t-- > 0){
            int n = sc.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);

    }
}