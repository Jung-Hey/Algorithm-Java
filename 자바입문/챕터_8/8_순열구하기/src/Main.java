import java.util.*;
public class Main {
    static Integer[] arr;
    static int n,m,answer=Integer.MAX_VALUE;
    public void DFS(int l,int sum){
        if(sum>m)return;
        if(answer<=l)return;
        if(sum==m){
            answer=Math.min(answer,l);
        }
        else{
            for(int i=0;i<n;i++){
                DFS(l+1,sum+arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr = new Integer[n];
        //ch = new int[n];
        for(int i=0;i<n;i++)arr[i]=kb.nextInt();
        m = kb.nextInt();
        Arrays.sort(arr,Collections.reverseOrder());
        //System.out.println(Arrays.toString(arr));
        T.DFS(0,0);
        System.out.println(answer);
    }
}


