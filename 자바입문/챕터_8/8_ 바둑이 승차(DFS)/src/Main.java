import java.util.*;
public class Main {
    static  int[] arr;
    static int limit=0;
    static int n;
    static int answer=0;
    static boolean flag = false;
    public void DFS(int v,int sum){
        System.out.println(v+" : "+sum);
        if(sum>limit) return;
        else if(v==n) {
            answer = Math.max(sum,answer);
        }
        else{
            DFS(v+1,sum+arr[v]);
            DFS(v+1,sum);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int ipt_limit = kb.nextInt();
        limit = ipt_limit;
        int ipt = kb.nextInt();
        n = ipt;
        arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }
        T.DFS(0,0);
        System.out.println(answer);
    }
}


