import java.util.*;
class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int n = board.length; // 세로 크기
        int m = board[0].length; // 가로 크기
        int [][] dist = new int[n][m];
        Queue<int[]> Q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    int ch [][]= new int [n][m];
                    ch[i][j]=1;
                    Q.offer(new int [] {i,j});
                    int L=0;
                    while (!Q.isEmpty()){
                        int len = Q.size();
                        L++;
                        for(int k=0; k< len; k++){
                            int[] cur = Q.poll();
                            for(int l=0; l<4; l++){
                                int ny = cur[0]+dy[l];
                                int nx = cur[1]+dx[l];
                                if(ny>=0&&ny<n&&nx>=0&&nx<m&& ch[ny][nx]==0){
                                    if(board[ny][nx] != 1){
                                        ch[ny][nx] = 1;
                                        dist[ny][nx]+=L;
                                        Q.offer(new int[]{ny,nx} );
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(board[i][j] == 4 && dist[i][j]>0) answer=Math.min(answer,dist[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{
                {3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}