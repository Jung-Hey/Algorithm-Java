import java.util.*;
public class Main {
    static  int[] arr;
    static int total=0;
    static int n;
    static boolean flag = false;
    public void DFS(int v,int sum){
        if(flag) return;
        else if(v==n){
            if(total-sum == sum) flag=true;
        }
        else if(sum>(total/2)) return;
        else{
            DFS(v+1,sum+arr[v]);
            DFS(v+1,sum);
        }

    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int ipt = kb.nextInt();
        n = ipt;
        arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
            total +=arr[i];
        }
        T.DFS(0,0);
        String answer = flag ? "YES":"NO";
        System.out.println(answer);
    }
}


