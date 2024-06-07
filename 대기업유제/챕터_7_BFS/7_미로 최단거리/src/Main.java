import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;
class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public int solution(int[][] board){
        int answer = -1;
        // ch접근제어 bfs
        int [][]dis = new int[7][7];
        dis[0][0]=-1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int L=0;
        while (!q.isEmpty()){
            L++;
            int len = q.size();
            for(int i=0; i<len; i++){
                int[] x = q.poll();
                for(int j=0; j<4; j++){
                    int ny = x[0] + dy[j];
                    int nx = x[1] + dx[j];
                    if(ny>=0 && ny<7 && nx>=0 && nx<7 && board[ny][nx]==0){
                        board[ny][nx]=1;
                        dis[ny][nx]=L;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        //for(int [] t : dis) System.out.println(Arrays.toString(t));
        if(dis[6][6]==0) return -1;

        return dis[6][6];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                     {0, 1, 1, 1, 1, 1, 0},
                     {0, 0, 0, 1, 0, 0, 0},
                     {1, 1, 0, 1, 0, 1, 1},
                     {1, 1, 0, 1, 0, 0, 0},
                     {1, 0, 0, 0, 1, 0, 0},
                     {1, 0, 1, 0, 0, 0, 0}};
//        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
//                     {0, 1, 1, 1, 1, 1, 0},
//                     {0, 0, 0, 1, 0, 0, 0},
//                     {1, 1, 0, 1, 1, 1, 1},
//                     {1, 1, 0, 1, 0, 0, 0},
//                     {1, 0, 0, 0, 1, 0, 0},
//                     {1, 0, 1, 0, 1, 0, 0}};

        System.out.println(T.solution(arr));
    }
}