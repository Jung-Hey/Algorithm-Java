import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] pm;
    public void DFS(int l){
        if(l==m) {
            for(int i=0;i<m;i++)System.out.print(pm[i]+" ");
            System.out.println();
        }
        else{
            for(int i=1;i<=n;i++){
                pm[l]=i;
                DFS(l+1);
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int I_n = kb.nextInt();
        n=I_n;
        int I_m = kb.nextInt();
        m=I_m;
        pm = new int[m];
        T.DFS(0);

    }
}


