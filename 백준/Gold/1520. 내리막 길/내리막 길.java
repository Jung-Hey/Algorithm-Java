import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] dp;
    static int n, m;

    public static int dfs(int y, int x) {
        // 도착지점 오면 도달할 경우의 수 추가
        if (y == n - 1 && x == m - 1) return 1;
        // 이미 해당 지점까지 왔으면 메모이제이션 활용
        if (dp[y][x] != -1) return dp[y][x];
        else {
            dp[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                // 다음이 내리막 길이면 계속해서 탐색
                if (arr[y][x] > arr[ny][nx]) dp[y][x] += dfs(ny, nx);
            }
            return dp[y][x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);

        // output
        System.out.println(answer);
    }
}
