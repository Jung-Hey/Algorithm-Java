import java.util.*;
class Main{
    static int[] pm,ch;
    static int n, m;
    public void DFS(int l,int s){
        if(l==m){
            for(int i : pm)System.out.print(i+" ");
            System.out.println();
        }
        else{
            //외우는게 맞음
            for(int i=s;i<=n;i++){
                pm[l]=i;
                DFS(l+1,i+1);
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        pm = new int[m];
        T.DFS(0,1);
    }
}