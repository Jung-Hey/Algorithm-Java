import java.util.*;
class Main{
    static int[][] arr,dis;
    static int [] dy = {-1,-1,0,1,1,1,0,-1};
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int answer= 0;
    static int n;

    public void DFS(int y,int x){
        for(int i=0;i<8;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny>=0&&ny<n&&nx>=0&&nx<n&&arr[ny][nx]==1){
                arr[ny][nx]=0;
                DFS(ny,nx);
            }
        }
    }
    public void solution(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){
                    answer++;
                    arr[i][j]=0; // 중요.이 초기화코드 까먹지말자
                    DFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr=new int[n][n];
        dis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) arr[i][j]=kb.nextInt();
        }
        T.solution();
        System.out.println(answer);
    }
}