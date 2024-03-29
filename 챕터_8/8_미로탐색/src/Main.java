import java.util.*;
class Main{
    static int[][] arr= new int [8][8];
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int answer= 0;
    static int n, m;
    //input
//    0 0 0 0 0 0 0
//    0 1 1 1 1 1 0
//    0 0 0 1 0 0 0
//    1 1 0 1 0 1 1
//    1 1 0 0 0 0 1
//    1 1 0 1 1 0 0
//    1 0 0 0 0 0 0
    public void DFS(int cy,int cx){
        if(cy == 7 && cx == 7)  answer+=1;
        else{
            for(int i=0;i<4;i++){
                int ny = cy+dy[i];
                int nx = cx+dx[i];
                boolean y_pass = ny>0 && ny<8;
                boolean x_pass = nx>0 && nx<8;
                if(y_pass && x_pass && arr[ny][nx] == 0){
                    arr[ny][nx]=1;
                    DFS(ny,nx);
                    arr[ny][nx]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
//        n=kb.nextInt();
//        m=kb.nextInt();
        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                arr[i][j]=kb.nextInt();
            }
        }
        arr[1][1]=1;
        T.DFS(1,1);
        System.out.println(answer);
    }
}