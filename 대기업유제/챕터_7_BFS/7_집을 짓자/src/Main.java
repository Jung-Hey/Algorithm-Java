//import java.util.*;
//class Solution {
//    static int[] dy = {-1,0,1,0};
//    static int[] dx = {0,1,0,-1};
//    public int solution(int[][] board){
//        int answer = Integer.MAX_VALUE;
//        int n = board[0].length;
//        int bCnt=0; //빌딩 수
//        // chTotal[][] == bCnt 인 좌표중에서 dis에서 찾아서 최소값 return
//        int [][] ch = new int [n][n]; // 각 빌딩에서 접근제어로 하나 끝날때마다 0으로 초기화 됨
//        int [][] chTotal = new int [n][n]; // 각 빌딩마다 접근한 횟수 누적
//        int [][] dis = new int [n][n];// 누적 거리
//        Queue<int[]> bq = new LinkedList<>(); // buildings
//        Queue<int[]> q = new LinkedList<>(); //
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(board[i][j] == 1){
//                    bCnt++;
//                    bq.offer(new int[] {i,j} ); // 빌딩 좌표만 모음
//                }
//            }
//        }
//        while (!bq.isEmpty()){
//            int [] b = bq.poll();// 빌딩 위치 큐
//            q.offer(b);// 각 빌딩마다 탐색할 큐
//            int L=0; // 각 빌딩의 탐색레벨
//            for(int[] c : ch) Arrays.fill(c,0);
//            ch[b[0]][b[1]] = 1; // 첫번째 빌딩 탐색은 1인것
//            while (!q.isEmpty()){
//                int len = q.size();
//                L++;
//                for(int i=0; i<len;i++){
//                    int [] x = q.poll();
//                    for(int j=0; j<4; j++){
//                        int ny = x[0] + dy[j];
//                        int nx = x[1] + dx[j];
//                        if(ny>=0 && ny<n && nx>=0 && nx<n && board[ny][nx]==0 && ch[ny][nx] == 0){
//                            ch[ny][nx] = 1; // 각 빌딩에 대한 접근제어로 각 빌딩마다 0으로 초기화 됨
//                            chTotal[ny][nx] = chTotal[ny][nx] + 1; // 각 빌딩들의 접근횟수 누적
//                            dis[ny][nx] =dis[ny][nx]+ L;// 각 빌딩들의 이동거리 누적됨
//                            q.offer(new int[] {ny,nx} );
//                        }
//                    }
//                }
//            }
//        }
//        // get min
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(chTotal[i][j]==bCnt){
//                    answer= Math.min(dis[i][j],answer);
//                }
//            }
//        }
//        if(answer == Integer.MAX_VALUE) return -1;
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Solution T = new Solution();
//        System.out.println(T.solution(new int[][]{
//                {1, 0, 2, 0, 1},
//                {0, 0, 0, 0, 0},
//                {0, 2, 1, 0, 0},
//                {2, 0, 0, 2, 2},
//                {0, 0, 0, 0, 0}}));
//        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
//        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
//        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
//    }
//}

import java.util.*;
class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public int solution(int[][] board){
        int answer = 0;
        int n = board[0].length;
        int [][] dis = new int[n][n];
        int emptyLand = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    //빌딩 만나면
                    q.offer(new int[]{ i, j });
                    answer = Integer.MAX_VALUE;
                    int L=0;
                    while (!q.isEmpty()){
                        L++;
                        int len = q.size();
                        for(int m = 0; m<len; m++){
                            int[] x = q.poll();
                            for(int k=0; k<4; k++) {
                                int ny = x[0] + dy[k];
                                int nx = x[1] + dx[k];
                                if(ny>=0 && ny<n && nx>=0 && nx<n && board[ny][nx]==emptyLand){
                                    board[ny][nx]--;
                                    dis[ny][nx] += L;
                                    q.offer(new int[] { ny, nx } );
                                    answer = Math.min(answer,dis[ny][nx]);
                                }
                            }
                        }
                    }
                    if(answer == Integer.MAX_VALUE) return -1;
                    emptyLand--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}