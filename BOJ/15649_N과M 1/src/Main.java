import java.util.*;
class Main {
    static int n,m;
    static int[] ch;
    static int[] pm;
    /**
     * dfs : 중복되지 않는 순열
     */
    public static void dfs(int l){
        if(l==m){
            for(int i : pm) System.out.print(i+" ");
            System.out.println();
        }
        else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[l]=i;
                    dfs(l+1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];
        pm = new int[m];
        dfs(0);
    }
}