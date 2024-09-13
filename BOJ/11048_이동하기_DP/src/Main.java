/**
 * bfs
 */
//import java.util.*;
//class Main {
//    static int n;
//    static int m;
//    static int[][] board;
//    static int[][] dis;
//    static int[] dx = {0,1,1};
//    static int[] dy = {1,0,1};
//    public static void bfs(){
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{0,0});
//        while (!q.isEmpty()){
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                int[] nc = q.poll();
//                int x = nc[0];
//                int y = nc[1];
//                for (int j = 0; j < 3; j++) {
//                    int nx = nc[0] + dx[j];
//                    int ny = nc[1] + dy[j];
//                    if(nx<0 || nx >=n || ny < 0 || ny >= m) continue;
//                    if(dis[x][y]+board[nx][ny] > dis[nx][ny]){
//                        dis[nx][ny] = dis[x][y]+board[nx][ny];
//                        q.offer(new int[] {nx,ny});
//                    }
//                }
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//
//        dis = new int[n][m];
//        board = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dis[i],-1);
//            for (int j = 0; j < m; j++) {
//                board[i][j] = sc.nextInt();
//            }
//        }
//        dis[0][0] = board[0][0];
//        bfs();
//        // out
//        System.out.println(dis[n-1][m-1]);
//
//    }
//}

/**
 * dp
 */
import java.util.*;
class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[n+1][m+1];
        board = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(board[i][j]+dp[i-1][j],board[i][j]+dp[i][j-1] );
            }
        }

        // out
        System.out.println(dp[n][m]);

    }
}