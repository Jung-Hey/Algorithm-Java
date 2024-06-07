import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[] dy= {0,0,0,1,-1};
        int[] dx= {0,1,-1,0,0};
        int n = board.length;
        int m = board[0].length;
        int[][] dis = new int[n][m];
        for(int[] d : dis)Arrays.fill(d,Integer.MAX_VALUE);
        dis[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            int nowCost = x[2];
            int d = board[x[0]][x[1]];
            if(x[2] > dis[x[0]][x[1]]) continue;
            for(int i=1; i<=4; i++){
                int ny = x[0] + dy[i];
                int nx = x[1] + dx[i];
                if(ny<0 || ny >= n || nx<0 || nx>=m) continue;
                int cost = d == i ? 0 : 1;
                if(dis[ny][nx] > nowCost + cost){
                    dis[ny][nx] = nowCost + cost;
                    pq.offer(new int[] {ny,nx,nowCost + cost});
                }
            }
        }

         return dis[n-1][m-1];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{3, 1, 3}
                                                , {1, 4, 2}
                                                , {4, 2, 3}}));
//        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
//        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
//        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
//        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}