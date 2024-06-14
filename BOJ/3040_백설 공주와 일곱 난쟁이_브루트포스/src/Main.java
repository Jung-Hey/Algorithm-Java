import java.util.*;
class Main {
    static int[] pm;
    static int sum;
    static boolean flag;
    public static void dfs(int l,int[]arr, int s){
        if(flag) return;
        //9개 입력받은 수 중에 2개를 조합으로 꺼냄 : 9난쟁이 중에 2명은 가짜이기 때문
        if(l==2){
            int tmp = arr[pm[0]]+arr[pm[1]];
            if(sum-tmp== 100){
                for(int i=1; i<=9; i++){
                    if(arr[i]!=arr[pm[0]] && arr[i]!=arr[pm[1]]){
                        System.out.println(arr[i]);
                    }
                }
                flag=true;
            }
        }
        else{
           for(int i=s; i<=9; i++){
               pm[l]=i;
               dfs(l+1,arr,i+1);
           }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input
        int[] arr = new int[9+1];
        flag=false;
        pm = new int[2];
        sum=0;
        for(int i=1; i<=9; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        dfs(0, arr,1);
    }
}