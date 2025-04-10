import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = 1_000_000 * 16;
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // dp [i][j] : i = 현재 노드, j = i 노드가 거쳐온 노드들에 대한 정보
        dp = new int[N][(1<<N)-1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0, 1));
    }

    static int dfs(int now, int visit) {
        // 모든 도시를 지난 경우
        if(visit == (1<<N)-1) {
            // now -> 0(출발도시)로 가는 경로가 존재해야 돌아갈 수 있음
            if(arr[now][0] == 0) return INF;
            return arr[now][0];
        }
        // 메모이제이션 활용
        if(dp[now][visit] != -1) return dp[now][visit];
        else {
            dp[now][visit] = INF;
            for(int i=0;i<N;i++) {
                // now -> 아직 방문하지 않는 i번 도시 가는 경로가 있는 경우
                if((visit & (1<<i)) == 0 && arr[now][i] != 0) {
                    int next = visit | (1 << i);
                    dp[now][visit] = Math.min(dfs(i, next) + arr[now][i], dp[now][visit]);   // 최소비용 갱신

                }
            }
        }

        return dp[now][visit];
    }
}