import java.util.*;
class Main {
    static int n;
    static int answer;
    static int[] arr;
    public static boolean isPass(int l){
        for (int i=0; i<l; i++){
            //열 검사
            if(arr[i]== arr[l]) return false;
            //대각선 검사
            if (Math.abs(i - l) == Math.abs(arr[i] - arr[l])) return false;
        }
        return true;
    }
    public static void dfs(int l){
       if(l==n) answer++;
       else{
           for(int i=0; i<n; i++ ){
               arr[l]=i;
               if(isPass(l))  dfs(l+1);
           }
       }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        answer=0;
        dfs(0);
        System.out.println(answer);

    }
}