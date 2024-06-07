import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dis = new int[n][m];
        for(int[] d : dis) Arrays.fill(d,n*m);
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->(a[2]-b[2]) );
        pq.offer(new int[]{0,0,0});
        dis[0][0]=0;
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            int nowCost = x[2];
            if(nowCost > dis[x[0]][x[1]]) continue;
            for(int i=0; i<4; i++){
                int ny = x[0] + dy[i];
                int nx = x[1] + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if(board[ny][nx]==0 && dis[ny][nx] > nowCost){
                    dis[ny][nx]=nowCost;
                    pq.offer(new int[] {ny,nx,nowCost});
                }
                else if( board[ny][nx]==1 && dis[ny][nx] > nowCost+1  ){
                    dis[ny][nx]=nowCost+1;
                    pq.offer(new int[] {ny,nx,nowCost+1});
                }
            }
        }

        answer = dis[n-1][m-1];
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},
                                                  {1, 0, 0, 1},
                                                  {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}