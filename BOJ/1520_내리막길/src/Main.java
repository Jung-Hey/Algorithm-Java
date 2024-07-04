import java.util.*;
class Main {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] arr;
    static int[][] dp;
    static int n,m;
    public static int dfs(int y, int x){
        // 목적지 도착 시 왔던 경로들을 1씩 더해줌
        if(y==n-1 && x==m-1) return 1;
        // 이미 계산 끝난 경로는 메모이제이션
        if(dp[y][x] != -1) {
            System.out.println(y+" "+x+" "+dp[y][x]);
            return dp[y][x];
        }
        // 탐색
        else{
            dp[y][x] = 0;
            for(int i=0; i<4; i++){
                int ny = y+ dy[i];
                int nx = x+ dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                // 다음 경로가 더 낮을때만
                if(arr[y][x] > arr[ny][nx]) {
                    dp[y][x] += dfs(ny,nx); // 다음 경로 누적 없으면 0이 누적될거임
                }
            }
            return dp[y][x];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
                dp[i][j]=-1;
            }
        }
        //solve
        int answer = dfs(0,0);
        //output
        System.out.println(answer);
        // test
//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < m; j++) {
//               System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}