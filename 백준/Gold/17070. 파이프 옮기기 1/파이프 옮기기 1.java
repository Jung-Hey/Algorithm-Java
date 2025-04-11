import java.util.*;
class Main {
    static int n;
    static int[][] arr;
    static int ans;

    static int HOR, VER, DIA; // 수평, 수직, 대각
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        HOR=0; VER=1; DIA=2; // 수직 수평 대각
        ans=0;
        dfs(0,1, HOR);
        System.out.println(ans);

    }

    private static void dfs(int r, int c, int status) {
        if(r==n-1 && c==n-1){
            ans++;
            return;
        }
        else{
            int nr = r+1;
            int nc = c+1;
            // 대각선 이동 (수직,수평,대각 어떤 방향에서도 대각선으로는 이동가능)
            if(canGo(nr,nc,true)){
                dfs(nr,nc,DIA);
            }
            // 수직아니면 수평으로 이동
            if(status != VER){
                nr = r;
                nc = c+1;
                if(canGo(nr,nc,false)){
                    dfs(nr,nc,HOR);
                }
            }
            // 수평아니면 수직가능
            if(status != HOR){
                nr = r+1;
                nc = c;
                if(canGo(nr,nc,false)){
                    dfs(nr,nc,VER);
                }
            }
        }
    }

    private static boolean canGo(int nr, int nc, boolean isDia) {
        if(nr>=n || nc >= n) return false;
        if(arr[nr][nc]==1) return  false;
        if( isDia && (arr[nr-1][nc] == 1 || arr[nr][nc-1] == 1) ){
            return false;
        }
        return true;
    }

}