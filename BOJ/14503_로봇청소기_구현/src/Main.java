import java.util.*;
class Main {
    static int status;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static int solve(int[][] arr, int y, int x, int n, int m){
        /**
         * status : 0인 경우 북쪽,  1인 경우 동쪽,  2인 경우 남쪽,  3인 경우 서쪽
         * 0 = 청소되지 않은 방 , 1 = 벽 , -1 = 청소된 방
         * 작동중지되는 경우 : 주변 4칸이 1 즉 다 벽이고 바라보는 방향에서 후진 불가 시 종료
         * 후진 가능 시 후진. (이떄 바라보는 방향은 그대로 유지)
         */
        //청소 횟수
        int answer=0;
        //작동 중지 플래그
        boolean flag = true;
        while (flag){
            // 현재 칸 청소가능하면 청소
            if(arr[y][x] == 0){
                arr[y][x] = -1;
                answer++;
            }
            boolean isCleaningO = false;
            for(int i=0; i<4; i++){
                int fy = y + dy[i];
                int fx = x + dx[i];
                //청소 되는 경우 탐색
                if(fy >= 0 && fy < n && fx >= 0 && fx < m && arr[fy][fx]==0 ) {
                    isCleaningO = true; // 청소가능
                    // 반시계 90도 돌린방향으로 이동
                    status =(status+3) % 4;
                    int ny = y + dy[status];
                    int nx = x + dx[status];
                    while ( !(ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx]==0) ){
                        ny=nx=0;//초기화
                        status = (status+3) % 4; //방향 재지정
                        ny = y + dy[status];
                        nx = x + dx[status];
                    }
                    y=ny;
                    x=nx;
                    break;
                }
            }
            //청소 안되는 경우 : 후진. 후진 불가 시 중지
            if(!isCleaningO){
                // 후진방향
                int backStatus = (status+2) % 4;
                int by = y + dy[backStatus];
                int bx = x + dx[backStatus];
                //후진가능
                if(by >= 0 && by < n && bx >= 0 && bx < m && arr[by][bx]!=1 ) {
                    y=by;
                    x=bx;
                }
                //안되면 종료
                else flag=false;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input
        // arr size
        int n = sc.nextInt();
        int m = sc.nextInt();
        // start point
        int y = sc.nextInt();
        int x = sc.nextInt();
        status = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //output
        System.out.println(solve(arr, y, x , n, m));
    }
}