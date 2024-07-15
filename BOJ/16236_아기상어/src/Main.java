import java.util.*;
class Main {
    static int sec; // 총 걸린시간
    static int eatCnt, sharkSize; // 먹은 생선 수와 상어 사이즈
    static int n,y,x;
    static int [][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean gotoEat(){
        // 먹을 수 있는 상어를 넣는 우선순위 큐
        PriorityQueue<int[]>fish = new PriorityQueue<>
                ((a,b) -> ( a[1]==b[1] ? a[2]-b[2] :a[1]-b[1] ) );
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ y, x}); // 상어
        boolean [][]  visited = new boolean[n][n];
        visited[y][x] = true;
        /**
         * BFS
         */
        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int[] po = q.poll();
                for(int j=0; j<4; j++){
                    int ny = po[0] + dy[j];
                    int nx = po[1] + dx[j];
                    if( ny<0 || ny>=n || nx<0 || nx>=n ) continue;
                    if( visited[ny][nx] || arr[ny][nx] > sharkSize) continue;
                    // 이동은 가능
                    q.offer(new int[]{ny,nx} );
                    visited[ny][nx] = true;
                    // 먹는것도 가능
                    if(arr[ny][nx]!=0 && arr[ny][nx]< sharkSize){
                        fish.offer(new int[]{ L+1,ny,nx} ); // 먹을 수 있는 생선의 [ 거리 + 좌표 ]
                    }
                }
            }
            /**
             * 레벨마다 먹을 수 있는 생선 체크 : 레벨마다 체크하면 그냥 거리체크안하고 좌표값만으로 따질 수 있음 + 한마리먹으면 바로 종료
             * fishCheck(fish)가 참이면 물고기 먹은걸로 처리되고 갱신(상어 크기와 위치, 걸린 시간 갱신) 후 종료
             */
            if(fishCheck(fish)){ //
                return true;
            }
            L++;
        }
        return false;
    }
    private static boolean fishCheck(PriorityQueue<int[]> fish) {
        if(fish.isEmpty()) return false;
        else{
            int [] p = fish.poll();
            int dis = p[0];
            int moveY = p[1];
            int moveX = p[2];
            // 먹은곳으로 상어 위치 변경
            y= moveY;
            x= moveX;
            // 물고기 먹음
            eatCnt++;
            // 먹은 물고기 갱신(크기 커질수도)
            if(sharkSize==eatCnt){
                sharkSize++;
                eatCnt=0;
            }
            // 먹은 물고기는 제거
            arr[moveY][moveX] = 0;
            // 먹으러 가는데 걸린시간 갱신
            sec+= dis;
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //
        int fishCnt=0;
        sharkSize=2; // 상어 사이즈
        eatCnt=0; // 먹은 물고기
        sec = 0; // 시간
        // 아기상어 시작 좌표
        y=x=0;
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int m = sc.nextInt();
                if( m<9 && m>0){
                    fishCnt++;
                    arr[i][j] = m;
                }
                //아기상어
                else if(m==9){
                    y=i;
                    x=j;
                }
            }
        }
        /**
         * 입력에 생선이 있으면 먹을 수 있을때까지 먹고 종료시간 출력
         */
        if(fishCnt>0){
            //먹을 수 있을때까지 먹음
            while (gotoEat()){}
        }
        // output
        System.out.println(sec);
    }
}