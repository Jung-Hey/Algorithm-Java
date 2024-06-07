import java.util.*;
class Solution {
    static int [] dy = {0,1,0,-1};
    static int [] dx = {1,0,-1,0};
    static int ay,ax ,status;
    static int second;
    // 내가 푼 코드 45분 소요
    public void dfs(int y, int x , int k, int limit, int[][]board ){
        if(second==k) {
            ay=y;
            ax=x;
            return;
        }
        else{
            int ny = y+ dy[status];
            int nx = x+ dx[status];
            boolean pass = ny>=0 && ny<limit && nx>=0 && nx<limit &&  board[ny][nx]==0;
            if(pass){
                second++;
                dfs(ny,nx, k , board.length , board);
            }
            else{
                while (true){
                    ny-=dy[status];
                    nx-=dx[status];
                    status= (status+1) % 4;
                    ny = y+ dy[status];
                    nx = x+ dx[status];
                    pass = ny>=0 && ny<limit && nx>=0 && nx<limit && board[ny][nx]==0;
                    second++;
                    if(second>=k)break;
                    if(pass)break;
                }
                if(second>=k){
                    ay=y;
                    ax=x;
                    return;
                }
                second++;
                dfs(ny,nx, k , board.length , board);
            }
        }
    }
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
//        ay=ax=status=0;
//        second=0;
//        dfs(0,0,k , board.length , board);
//        answer[0]=ay;
//        answer[1]=ax;

        //강의풀이 : 내가 푼 방식과 유사하지만 굳이 dfs 재귀필요없이 훨씬 간결하게 구현 가능
        int n = board.length;
        ay=ax=status=second=0;
        int y=0,x=0;
        while (second<k){
            second++;
            int ny = y+ dy[status];
            int nx = x+ dx[status];
            if(ny<0 || ny>=n || nx<0 || nx>=n || board[ny][nx]==1){
                status=(status+1)%4;
                continue;
            }
            y=ny;
            x=nx;
        }
        answer[0]=y;
        answer[1]=x;


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));

        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));



    }
}