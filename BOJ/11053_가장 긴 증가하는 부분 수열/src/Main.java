import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int[] dp= new int[n];
        int answer=1;
        dp[0]=1;
        //solve
        for(int i=1; i<n; i++){
            int tmp=0;
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j]) tmp=Math.max(tmp, dp[j]);
            }
            dp[i]=tmp+1;
            answer=Math.max(answer,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}