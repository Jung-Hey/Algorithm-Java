import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb;
	static int answer, brickCount;
    static int[][] map;
    static int n, w, h;
    static int[] pm;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            pm = new int[n];
            brickCount=0;
        	for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					int v = Integer.parseInt(st.nextToken());
					map[i][j] = v;
					if(v != 0) brickCount++;// 벽돌 개수 카운팅
				}
			}

            answer = brickCount;
            dfs(0);

			//brickSimulation();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int l) {
        if (l == n) {
            answer = Math.min(answer, brickSimulation());
            return;
        }

        for (int i = 0; i < w; i++) {
            pm[l] = i;
            dfs(l + 1);
        }
    }

    private static int brickSimulation() {
        int total = brickCount;
        int[][] copyMap = copy();

        for (int idx : pm) {
            Queue<int[]> q = new ArrayDeque<>();
            // 구슬을 떨어뜨림
            for (int i = 0; i < h; i++) {
                int value = copyMap[i][idx];
                if (value > 0) {
                    copyMap[i][idx] = 0;
                    total--;
                    if (value > 1) {
                        q.offer(new int[]{i, idx, value});
                    }
                    break;
                }
            }
            boolean needApplyGravity = !q.isEmpty();
            // 연쇄 폭발
            while (!q.isEmpty()) {
                int[] bomb = q.poll();
                int x = bomb[0], y = bomb[1], range = bomb[2];

                for (int d = 0; d < 4; d++) {
                    for (int dist = 1; dist < range; dist++) {
                        int nx = x + dx[d] * dist;
                        int ny = y + dy[d] * dist;
                        if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                        if (copyMap[nx][ny] == 0) continue;
                        int next = copyMap[nx][ny];
                        copyMap[nx][ny] = 0;
                        total--;
                        if (next > 1) {
                            q.offer(new int[]{nx, ny, next});
                        }
                    }
                }
            }
            // 중력 적용 
            if(needApplyGravity) applyGravity(copyMap);
        }
        return total;
    }

    private static void applyGravity(int[][] copyMap) {
	   for (int i = 0; i < w; i++) {
           Queue<Integer> q = new ArrayDeque<>();
           for (int j = h-1; j >= 0; j--) {
        	   int num = copyMap[j][i];
        	   if(num > 0) q.offer(num);
        	   copyMap[j][i]=0;
           }
           for (int j = h-1; j >= 0; j--) {
        	   if(q.isEmpty()) break;
        	   copyMap[j][i] = q.poll();
           }
       }
    }

    private static int[][] copy() {
        int[][] copyMap = new int[h][w];
        for (int i = 0; i < h; i++) {
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }
}