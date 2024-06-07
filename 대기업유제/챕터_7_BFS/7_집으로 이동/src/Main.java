import java.util.*;
class Solution {
    public int solution(int[] pool, int a, int b, int home){
        int answer = -1;
        int[][] ch = new int[10001][2];
        //웅덩이 처리
        for(int i : pool) {
            ch[i][0] = 1;
            ch[i][1] = 1;
        }
        ch[0][0] = 1;
        ch[1][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0}); //start
        int L=0;
        while (!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int[] cur = q.poll();
                if(cur[0] == home) return L;
                //front
                int nx = cur[0] + a;
                if(nx < 10001 && ch[nx][0]==0){
                    ch[nx][0] = 1;
                    q.offer(new int[]{ nx ,0 });
                }
                //back
                nx = cur[0] - b;
                if(nx>=0 && ch[nx][1]==0 && cur[1]==0){
                    ch[nx][1] = 1;
                    q.offer(new int[]{ nx ,1 });
                }
            }
            L++;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}