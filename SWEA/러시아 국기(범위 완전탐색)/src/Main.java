import java.util.*;
public class Main {

    public static void main(String[] args) {
        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans=0;
        int[] W = new int[n];    // 각 행에서의 색상 개수
        int[]B = new int[n];
        int[]R = new int[n];
        // 1. 각 행의 W, B, R 개수 저장
        for(int i=0;i<n;i++){
            String s = sc.next();
            for(int j=0;j<m;j++){
                if( s.charAt(j) == 'W') W[i]++;
                else if(s.charAt(j) == 'B') B[i]++;
                else R[i]++;
            }
        }
//        for(int i=0;i<n;i++){
//            System.out.println("i : "+i + " "+ W[i]);
//            System.out.println("i : "+i + " "+ B[i]);
//            System.out.println("i : "+i + " "+ R[i]);
//        }
        // 2. 모든 경우의 수를 확인하여 최솟값 구하기
        int sum = 0;
        for(int i=1; i<=n-2; i++) {    //1~2] W가 나올 수 있는 경우의 수 : 1 ~ N-2
            for(int j=i; j<n-1; j++) {    //2까지탐] W기준 B가 나올 수 있는 경우 : 2 ~ N-1
                int wCnt = 0;
                int bCnt = 0;
                int rCnt = 0;
                for(int k=0; k<i; k++) wCnt += W[k];    // W가 나올 수 있는 행에서 W의 개수
                for(int k=i; k<=j; k++) bCnt += B[k];    // W가 나올 수 있는 행에서 B의 개수
                for(int k=j+1; k<n; k++) rCnt += R[k];    // W가 나올 수 있는 행에서 R의 개수
                System.out.println(wCnt+" "+bCnt+" "+rCnt);
                sum = Math.max(sum, wCnt+bCnt+rCnt);    // sum이 높을 수록 새로 칠해야하는 칸의 개수가 작음
            }
        }
        sum = n * m - sum;
        System.out.println("ans : "+sum);

    }
}