import java.util.*;

class Main {
    private static class Coins {
        int x1;
        int y1;
        int x2;
        int y2;
        int count;

        public Coins(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }

    static int n;
    static int m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    static char[][] board;

    static void bfs(Coins coins) {
        Queue<Coins> q = new LinkedList<>();
        q.offer(coins);
        while (!q.isEmpty()) {
            Coins cc = q.poll();
            // 10번 이상 움직이면 실패
            if (cc.count >= 10) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx1 = cc.x1 + dx[i];
                int ny1 = cc.y1 + dy[i];
                int nx2 = cc.x2 + dx[i];
                int ny2 = cc.y2 + dy[i];

                boolean state1 = isValidIndex(nx1, ny1); // false 면 떨어진 상태
                boolean state2 = isValidIndex(nx2, ny2); //

                // 하나의 동전만 떨어진 경우
                if ((state1 && !state2) || (!state1 && state2)) {
                    ans = Math.min(ans, cc.count + 1);
                    return; // 종료
                }
                // 두 동전이 모두 떨어진 경우, 무시
                if (!state1 && !state2) {
                    continue;
                }
                // 동전이 벽에 부딪힌 경우 다시 원래 위치로
                if (state1 && board[nx1][ny1] == '#') {
                    nx1 = cc.x1;
                    ny1 = cc.y1;
                }
                if (state2 && board[nx2][ny2] == '#') {
                    nx2 = cc.x2;
                    ny2 = cc.y2;
                }


                q.offer(new Coins(nx1, ny1, nx2, ny2, cc.count + 1));
            }
        }
    }

    // 인덱스 범위 확인
    private static boolean isValidIndex(int nx, int ny) {
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int cnt = 0;
        int x1 = 0, y1 = 0;
        Coins coins = null;
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            board[i] = str.toCharArray();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'o') {
                    if (cnt++ == 0) {
                        x1 = i;
                        y1 = j;
                    } else {
                        coins = new Coins(x1, y1, i, j, 0);
                    }
                }
            }
        }

        bfs(coins);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}