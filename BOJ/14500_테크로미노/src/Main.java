import java.util.*;
class Main {
    static int n,m;
    static int[][] board;
    static int[][] ch;
    static int answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void dfs(int x, int y , int l , int temp){
        // 테크로미노는 정사각형 도형 4개를 합친거기 때문에 여기서 최대값 갱신
        if(l==4){
            if(answer < temp) answer = temp;
        }
        else {
            for (int i = 0; i <4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx >= n || ny<0 || ny >= m) continue; // 배열 인덱스 범위 제한
                if(ch[nx][ny]== 1) continue; // 방문한 곳은 또 방문안함
                // 테크로미노 두칸만들어서 꺾어줘서 ㅗ ,ㅜ 이런 모양 만들어야 함
                if(l==2){
                    ch[nx][ny] = 1; // 방문
                    dfs(x,y,l+1, temp+board[nx][ny]);
                    ch[nx][ny] = 0; // 백트래킹
                }
                ch[nx][ny] = 1; // 방문
                dfs(nx,ny,l+1, temp+board[nx][ny]);
                ch[nx][ny] = 0; // 백트래킹
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer=Integer.MIN_VALUE;
        board = new int[n][m]; // 점수판
        ch = new int[n][m]; // 테크로미노 시작지점 최대값
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        //
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ch[i][j] = 1; // 방문
                dfs(i,j,1, board[i][j]);
                ch[i][j] = 0;
            }
        }

        //
        System.out.println(answer);

    }
}