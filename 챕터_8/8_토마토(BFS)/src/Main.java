import java.util.*;
class tomato{
    int y;
    int x;
    tomato(int y,int x){
        this.y=y;
        this.x=x;
    }
}
class Main{
    static int[][] arr,dis;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int answer= Integer.MIN_VALUE;
    static Queue<tomato> que = new LinkedList<>();
    static int n, m;
    //input

    public void BFS(){
        while (!que.isEmpty()){
            tomato tmp = que.poll();
            for(int i=0;i<4;i++){
                int ny = tmp.y+dy[i];
                int nx = tmp.x+dx[i];
                boolean y_pass = ny>-1 && ny<m;
                boolean x_pass = nx>-1 && nx<n;
                if(y_pass && x_pass && arr[ny][nx] == 0){
                    arr[ny][nx]=1;
                    que.offer(new tomato(ny,nx));
                    dis[ny][nx]=dis[tmp.y][tmp.x]+1;
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        arr=new int[m][n];
        dis=new int[m][n];
        //모두 익은 토마토(1) 이면 0출력
        boolean flag1 = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=kb.nextInt();
                if(arr[i][j]==1){
                    que.offer(new tomato(i,j));
                }
                else flag1=false;
            }
        }
        if(flag1){
            System.out.println(0);
            return;
        };
        T.BFS();
        //안익은 토마토가 있으면 -1 출력
        boolean flag2=true;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                answer=Math.max(answer,dis[i][j]);
                if(arr[i][j]==0)flag2=false;
            }
        }
        if(flag2)System.out.println(answer);
        else System.out.println(-1);
    }
}