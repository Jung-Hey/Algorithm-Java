import java.util.*;
public class Main {
    static  int[] arr,pm,ch;
    static int n,m;
    public void DFS(int l){
        if(l==m) {
            for(int i=0;i<m;i++) System.out.print(pm[i]+" ");
            System.out.println();
        }
        else{
            for(int i=0;i<n;i++){
                if(ch[i]==0){
                    ch[i]=1; //
                    pm[l]=arr[i];
                    DFS(l+1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        for(int i=0;i<n;i++) arr[i]=kb.nextInt();
        T.DFS(0);
    }
}


