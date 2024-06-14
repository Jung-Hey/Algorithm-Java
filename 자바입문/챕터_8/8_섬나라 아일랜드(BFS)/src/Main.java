import java.util.*;
class Point{
    int y;
    int x;
    Point(int y,int x){
        this.y=y;
        this.x=x;
    }
}
class Main{
    static Queue<Point> que = new LinkedList<>();
    static int[][] arr;
    static int [] dy = {-1,-1,0,1,1,1,0,-1};
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int answer= 0;
    static int n;

    public void BFS(int y,int x){
        que.offer(new Point(y,x));
        while (!que.isEmpty()){
            Point tmp = que.poll();
            for(int i=0;i<8;i++){
                int ny=tmp.y+dy[i];
                int nx=tmp.x+dx[i];
                if(ny>=0&&ny<n&&nx>=0&&nx<n&&arr[ny][nx]==1){
                    arr[ny][nx]=0;
                    BFS(ny,nx);
                }
            }
        }

    }
    public void solution(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){
                    answer++;
                    arr[i][j]=0; // 중요.이 초기화코드 까먹지말자
                    BFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) arr[i][j]=kb.nextInt();
        }
        T.solution();
        System.out.println(answer);
    }
}