import java.util.*;

class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N,L,R,answer;
    static int [][] arr;
    static boolean [][] visited;
    static ArrayList<int[]> moveList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = 0;
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //
        visited= new boolean[N][N];

        boolean hasMoved;
        do {
            hasMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int total = bfs(i, j);
                        if (moveList.size() > 1) {
                            moveEffect(total);
                            hasMoved = true;
                        }
                    }
                }
            }
            if (hasMoved) {
                answer++;
                visited = new boolean[N][N]; // 방문 기록 초기화
            }
        } while (hasMoved);

        System.out.println(answer);


    }

    private static void moveEffect(int total) {
        int avg = total / moveList.size();
        for(int[] point : moveList){
            arr[point[0]][point[1]] = avg;
        }
    }

    private static int bfs(int x, int y) {
        int total = arr[x][y];
        visited[x][y] = true;
        moveList = new ArrayList<>();
        moveList.add(new int[] {x,y}); // 이동 내역
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        //boolean isMoved = false;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                int diff = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]);
                if( diff >= L && diff <= R){
                    //isMoved = true; // 이동 발생
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny} );
                    moveList.add(new int[] {nx, ny});
                    total += arr[nx][ny];
                }
            }
        }
        //if(isMoved) answer++;

        return total;

    }


}