import java.util.*;
class Main {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static int dijkstra(int[][] arr, int n){
        int[][] dis = new int[n][n];
        //초기화
        for(int i=0; i<n;i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = arr[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{ 0, 0, dis[0][0] });
        //다익스트라
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            int cost = x[2];
            if(cost > dis[x[0]][x[1]]) continue; //성능개선 추가
            for(int i=0; i<4; i++){
                int ny = x[0] + dy[i];
                int nx = x[1] + dx[i];
                if(ny < 0|| ny >= n || nx < 0|| nx >= n) continue;
                if(dis[ny][nx] > cost+arr[ny][nx]){
                    dis[ny][nx] = cost+arr[ny][nx];
                    pq.offer(new int[]{ ny,nx,cost+arr[ny][nx] });
                }
            }
        }
        return dis[n-1][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int idx=1;
        while (true){
            int n = sc.nextInt();
            //종료
            if(n==0){
                System.out.println(sb);
                break;
            }
            //ipt
            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            //solve
            int ans = dijkstra(arr,n);
            sb.append("Problem ").append(idx).append(": ").append(ans).append("\n");
            idx++;
        }
    }
}
