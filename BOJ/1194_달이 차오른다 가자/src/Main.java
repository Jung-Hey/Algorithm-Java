import java.util.*;
class Main {
    static Queue<int[]> q;
    static char[][] board;
    static int n, m, sy, sx;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs() {
        boolean[][][] visited = new boolean[n][m][64]; // 열쇠 상태를 포함한 방문 배열
        visited[sy][sx][0] = true; // 시작점 방문 처리
        q.offer(new int[]{sy, sx, 0, 0}); // 좌표(y, x), 이동거리, 열쇠 상태

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            int keys = cur[3];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (board[ny][nx] == '#') continue; // 벽이면 스킵
                if (board[ny][nx] == '1') {
                    return dist + 1; // 출구를 찾으면 거리 반환
                }
                int newKeys = keys;
                // 소문자이면 열쇠를 얻음
                if (board[ny][nx] >= 'a' && board[ny][nx] <= 'f') {
                    newKeys = (newKeys | (1 << (board[ny][nx] - 'a')));
                }
                // 대문자이면 열쇠가 있는지 확인
                if (board[ny][nx] >= 'A' && board[ny][nx] <= 'F') {
                    if ((newKeys & (1 << (board[ny][nx] - 'A'))) == 0) {
                        continue; // 열쇠가 없으면 스킵
                    }
                }
                // 새로운 위치이거나 열쇠 상태에서 처음 방문하는 경우
                if (!visited[ny][nx][newKeys]) {
                    visited[ny][nx][newKeys] = true; // 방문 처리
                    q.offer(new int[]{ny, nx, dist + 1, newKeys});
                }
            }
        }

        return -1; // 출구를 찾을 수 없으면 -1 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = new LinkedList<>();
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '0') {
                    sy = i;
                    sx = j;
                }
            }
        }

        System.out.println(bfs());
    }
}