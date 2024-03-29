import java.util.*;
class point{
    int y;
    int x;
    point(int y,int x){
        this.y=y;
        this.x=x;
    }
}
class Main{
    static int[][] arr= new int [8][8];
    static int[][] dis= new int [8][8];
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int answer= Integer.MAX_VALUE;
    static Queue<point> que = new LinkedList<>();
    static int n, m;
    //input
//    0 0 0 0 0 0 0
//    0 1 1 1 1 1 0
//    0 0 0 1 0 0 0
//    1 1 0 1 0 1 1
//    1 1 0 0 0 0 1
//    1 1 0 1 1 0 0
//    1 0 0 0 0 0 0
    public void BFS(int cy,int cx){
        que.offer(new point(cy,cx));
        while (!que.isEmpty()){
            point tmp = que.poll();
            for(int i=0;i<4;i++){
                int ny = tmp.y+dy[i];
                int nx = tmp.x+dx[i];
                boolean y_pass = ny>0 && ny<8;
                boolean x_pass = nx>0 && nx<8;
                if(y_pass && x_pass && arr[ny][nx] == 0){
                    arr[ny][nx]=1;
                    que.offer(new point(ny,nx));
                    dis[ny][nx] = dis[tmp.y][tmp.x]+1;
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++) arr[i][j]=kb.nextInt();
        }
        arr[1][1]=1;
        T.BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}