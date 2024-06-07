import java.util.*;
class Solution {
    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] dis = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for(int[] d : dis) Arrays.fill(d,Integer.MAX_VALUE);
        dis[s[0]][s[1]] = 0;
        pq.offer(new int[] {s[0],s[1],0} );
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            if(x[2] > dis[x[0]][x[1]]) continue;
            for(int i=0;i<4;i++){
                int ny = x[0];
                int nx = x[1];
                int len = x[2];
                while (ny>=0 && ny<n && nx>=0 && nx<m && board[ny][nx]==0){
                    ny+=dy[i];
                    nx+=dx[i];
                    len++;
                }
                ny-=dy[i];
                nx-=dx[i];
                len--;
                if(dis[ny][nx]>len){
                    dis[ny][nx] = len;
                    pq.offer(new int[]{ny,nx,len});
                }

            }
        }

        //for(int[] d : dis) System.out.println(Arrays.toString(d));
        answer = dis[e[0]][e[1]]==Integer.MAX_VALUE ? -1 : dis[e[0]][e[1]];

        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0},
                                                  {0, 0, 1, 0, 0, 0},
                                                  {0, 0, 0, 0, 1, 0},
                                                  {1, 0, 1, 1, 1, 0},
                                                  {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

