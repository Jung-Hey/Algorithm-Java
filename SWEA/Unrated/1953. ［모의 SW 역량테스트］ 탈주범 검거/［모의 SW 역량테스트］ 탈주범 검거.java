import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb;
    static int sr,sc;
    static int [][] arr;
    // 터널의 인덱스 번호당 갈 수 있는 방향
    static int[][] tunnelDir = {
            {},                 
            {0, 1, 2, 3},       // 1
            {0, 2},             // 2
            {1, 3},             // 3
            {0, 1},             // 4
            {1, 2},             // 5
            {2, 3},             // 6
            {0, 3}              // 7
    };


    public static void main(String[] args) throws NumberFormatException, IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()) , t=0;
        while(t++ < tc) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int answer = bfs(r,c,arr, second);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int r, int c, int[][] arr, int second) {
        int res = 1;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        boolean[][] isVisited = new boolean[r][c];
        isVisited[sr][sc] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr,sc});
        int level = 1;
        while (!q.isEmpty()){
            if(level == second) return res;
            int len  = q.size();
            for (int i = 0; i < len; i++) {
                int [] now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    // 아무것도 없거나 이미 방문한 곳이면 패스
                    if(arr[nx][ny]==0 || isVisited[nx][ny]) continue;
                    if (isConnected(arr[now[0]][now[1]], arr[nx][ny], j)) {
                        res++;
                        isVisited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
            level++;
        }
        return res;
    }

    private static boolean isConnected(int from, int to, int dir) {
        // 현재 위치에서 해당 방향으로 통과 가능
        boolean pass = false;
        for (int d : tunnelDir[from]) {
            if (d == dir) {
                pass = true;
                break;
            }
        }
        if (!pass) return false;

        // 다음 위치에서 반대 방향으로 통과 가능
        int reverse = (dir + 2) % 4; // 반대 방향
        for (int d : tunnelDir[to]) {
            if (d == reverse) return true;
        }
        return false;

    }


}
