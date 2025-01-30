import java.io.*;
import java.util.*;
class Main {
    static int n,m;
    static int i,j;
    static char[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (i = 0; i < n; i++) {
            String str = br.readLine();
            for (j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                boolean [][] visited = new boolean[n][m];
                visited[i][j] = true;
                bfs(i, j, visited, board[i][j], 1);
            }
        }
        System.out.println("No");

    }

    private static void bfs(int x, int y, boolean[][] visited, char dot, int len) {
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 인덱스 범위 체크
            if( nx < 0 || nx >= n || ny < 0 || ny >= m ) continue;
            // 방문안했고, 시작지점과 같은(이어지는) 부분 탐색
            if( !visited[nx][ny] && board[nx][ny] == dot ){
                visited[nx][ny] = true;
                System.out.println(nx+" "+ny+" "+visited[nx][ny]+" "+ (len+1) );
                bfs(nx,ny,visited,dot, len+1);
            }
            else if( len >= 4 && i == nx && j == ny ){
                System.out.println(nx+" "+ny+" "+"len : "+len);
                System.out.println("Yes");
                System.exit(0);
                return;
            }
        }
    }
}