import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n, x, y, status;  // status: 0 가로, 1 세로 (B의 상태)
    static int ex, ey, estat;    // E의 중앙 좌표와 방향 (가로: 0, 세로: 1)
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 시작 로그(B) 상태 찾기 (중심 좌표와 방향)
        int bCount = 0;
        findB: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'B') {
                    bCount++;
                    if(bCount == 2) { // 두 번째 B를 만났을 때가 중앙 좌표
                        x = i;
                        y = j;
                        // 가로: 왼쪽 또는 오른쪽에 B가 있으면 status는 기본 0
                        if(j - 1 >= 0 && arr[i][j - 1] == 'B') {
                            // status remains 0 (가로)
                        } else if(j + 1 < n && arr[i][j + 1] == 'B') {
                            // status remains 0 (가로)
                        } else {
                            status = 1; // 세로
                        }
                        break findB;
                    }
                }
            }
        }

        // 도착 로그(E) 상태 찾기 (중심 좌표와 방향)
        int eCount = 0;
        findE: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'E') {
                    eCount++;
                    if(eCount == 2) {
                        ex = i;
                        ey = j;
                        if(j - 1 >= 0 && arr[i][j - 1] == 'E') {
                            // horizontal: estat 기본 0
                        } else if(j + 1 < n && arr[i][j + 1] == 'E') {
                            // horizontal
                        } else {
                            estat = 1; // vertical
                        }
                        break findE;
                    }
                }
            }
        }

  
        System.out.println(bfs());
    }

    private static int bfs() {
        // visited[방향][중심 x][중심 y]
        boolean[][][] isVisited = new boolean[2][n][n];
        isVisited[status][x][y] = true;

        Queue<int[]> q = new ArrayDeque<>();
        // 상태: {orientation, x, y, 이동 횟수}
        q.offer(new int[] {status, x, y, 0});

        while(!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] now = q.poll();
                int s = now[0];  // 현재 방향
                int curX = now[1];
                int curY = now[2];
                int move = now[3];

                // 도착 상태: 중심 좌표와 방향이 모두 일치해야 함
                if(curX == ex && curY == ey && s == estat) {
                    return move;
                }

                // 상(U)
                if(canMove(isVisited, curX, curY, s, 'U')) {
                    isVisited[s][curX - 1][curY] = true;
                    q.offer(new int[] {s, curX - 1, curY, move + 1});
                }
                // 하(D)
                if(canMove(isVisited, curX, curY, s, 'D')) {
                    isVisited[s][curX + 1][curY] = true;
                    q.offer(new int[] {s, curX + 1, curY, move + 1});
                }
                // 좌(L)
                if(canMove(isVisited, curX, curY, s, 'L')) {
                    isVisited[s][curX][curY - 1] = true;
                    q.offer(new int[] {s, curX, curY - 1, move + 1});
                }
                // 우(R)
                if(canMove(isVisited, curX, curY, s, 'R')) {
                    isVisited[s][curX][curY + 1] = true;
                    q.offer(new int[] {s, curX, curY + 1, move + 1});
                }
                // 회전(T)
                if(canMove(isVisited, curX, curY, s, 'T')) {
                    int ns = (s == 1 ? 0 : 1);
                    isVisited[ns][curX][curY] = true;
                    q.offer(new int[] {ns, curX, curY, move + 1});
                }
            }
        }
        return 0;
    }

    private static boolean canMove(boolean[][][] isVisited, int x, int y, int s, int cmd) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        switch (cmd) {
            case 'U': {
                if(s == 0) { // 가로일 때: (x, y-1), (x, y), (x, y+1)
                    if(x - 1 < 0) return false;
                    for (int d : new int[] {-1, 0, 1}) {
                        int ny = y + d;
                        if(ny < 0 || ny >= n) return false;
                        if(arr[x - 1][ny] == '1') return false;
                    }
                    if(isVisited[0][x - 1][y]) return false;
                    return true;
                } else { // 세로일 때: (x-1, y), (x, y), (x+1, y)
                    if(x - 2 < 0) return false;
                    if(arr[x - 2][y] == '1' || arr[x - 1][y] == '1') return false;
                    if(isVisited[1][x - 1][y]) return false;
                    return true;
                }
            }
            case 'D': {
                if(s == 0) { // 가로일 때
                    if(x + 1 >= n) return false;
                    for (int d : new int[] {-1, 0, 1}) {
                        int ny = y + d;
                        if(ny < 0 || ny >= n) return false;
                        if(arr[x + 1][ny] == '1') return false;
                    }
                    if(isVisited[0][x + 1][y]) return false;
                    return true;
                } else { // 세로일 때
                    if(x + 2 >= n) return false;
                    if(arr[x + 1][y] == '1' || arr[x + 2][y] == '1') return false;
                    if(isVisited[1][x + 1][y]) return false;
                    return true;
                }
            }
            case 'L': {
                if(s == 0) { // 가로일 때: 이동 후 (x, y-2), (x, y-1), (x, y)
                    if(y - 2 < 0) return false;
                    if(arr[x][y - 2] == '1' || arr[x][y - 1] == '1') return false;
                    if(isVisited[0][x][y - 1]) return false;
                    return true;
                } else { // 세로일 때: 이동 후 (x-1, y-1), (x, y-1), (x+1, y-1)
                    if(y - 1 < 0) return false;
                    for (int d : new int[] {-1, 0, 1}) {
                        int nx = x + d;
                        if(nx < 0 || nx >= n) return false;
                        if(arr[nx][y - 1] == '1') return false;
                    }
                    if(isVisited[1][x][y - 1]) return false;
                    return true;
                }
            }
            case 'R': {
                if(s == 0) { // 가로일 때: 이동 후 (x, y), (x, y+1), (x, y+2)
                    if(y + 2 >= n) return false;
                    if(arr[x][y + 1] == '1' || arr[x][y + 2] == '1') return false;
                    if(isVisited[0][x][y + 1]) return false;
                    return true;
                } else { // 세로일 때: 이동 후 (x-1, y+1), (x, y+1), (x+1, y+1)
                    if(y + 1 >= n) return false;
                    for (int d : new int[] {-1, 0, 1}) {
                        int nx = x + d;
                        if(nx < 0 || nx >= n) return false;
                        if(arr[nx][y + 1] == '1') return false;
                    }
                    if(isVisited[1][x][y + 1]) return false;
                    return true;
                }
            }
            case 'T': {
                int ns = (s == 1 ? 0 : 1);
                if(isVisited[ns][x][y]) return false;
                // 회전 시 중심을 둘러싼 3×3 구역이 모두 빈 칸이어야 함
                if(x == 0 || x == n - 1 || y == 0 || y == n - 1) return false;
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(arr[nx][ny] == '1') return false;
                }
                return true;
            }
        }
        return false;
    }
}