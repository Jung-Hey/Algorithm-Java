import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static char [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) arr[i] = br.readLine().toCharArray();
        // solve
        System.out.println(bfs());
    }

    private static int bfs() {
        int[][] dis = new int[n][m];
        for (int i = 0; i < n ; i++)  Arrays.fill(dis[i],Integer.MAX_VALUE);
        dis[0][0] = 0;

        //PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        Queue<int[]> pq = new LinkedList<>();
        // 좌표, 벽부순횟수, 이동거리
        pq.offer(new int[] {0,0,0,1});

        while (!pq.isEmpty()){
            int len = pq.size();
            for (int i = 0; i < len ; i++) {
                int [] now = pq.poll();
                if (now[0] == n-1 && now[1] == m-1) return n==1 && m == 1 ?  1 : now[3];
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (now[2] > dis[now[0]][now[1]]) continue;
                    //if (nx == n-1 && ny == m-1) return now[3]+1;
                    // 벽이 아닐경우 최소거리만 갱싱
                    if (arr[nx][ny] == '0' && dis[nx][ny] > now[2]) {
                        dis[nx][ny] = now[2];
                        pq.offer(new int[]{nx, ny, now[2], now[3]+1});
                    }
                    // 벽일 경우 부술 수 있나 확인하고 최소거리 갱신
                    else if (arr[nx][ny] == '1' && dis[nx][ny] > now[2] && now[2] == 0) {
                        dis[nx][ny] = now[2] + 1;
                        pq.offer(new int[]{nx, ny, now[2] + 1, now[3]+1});
                    }
                }
            }
          //  print(level,dis);
        }

        //System.out.println("end");
        return -1;




    }

    private static void print(int l, int[][] dis) {
        System.out.println("level = "+l);
        for (int i = 0; i < n ; i++){
            System.out.println(Arrays.toString(dis[i]));
        }
    }

}