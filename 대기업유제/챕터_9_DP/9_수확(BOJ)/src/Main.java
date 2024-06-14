import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] psum = new int[n+1];
        int[][] dy =  new int[n+1][n+1];
        // input
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
        //psum
        int ps=0;
        for(int i=1; i<=n; i++){
            ps += arr[i];
            psum[i]= ps;
        }
        //dp
        for(int i=1; i<=n;i++){
            dy[i][i] = arr[i];
        }
        for(int i=1; i<=n;i++){
            for(int j=i+1; j<=n;j++){
                //System.out.println((j-i)+" "+j);
                int bigger = Math.max(dy[j-i+1][j],dy[j-i][j-1]);
                int sum=0;
                //for(int k=(j-i); k<=j; k++) sum+= arr[k];
                //누적합 성능개선
                sum = psum[j] - psum[j-i-1];
                dy[j-i][j] = bigger + sum;
            }
        }
        //output
        System.out.println(dy[1][n]);
        //for(int i=1; i<=n; i++) System.out.println(Arrays.toString(dy[i]));
    }
}

