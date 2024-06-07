import java.util.*;
class Solution {
    public int solution(int[][] board){
        // 20분 소요
        // 0-빈칸,1-나무, 2-현수,3-강아지
        int answer = 0;
        boolean isFind= false;
        //방향
        int [] dy={-1,0,1,0};
        int [] dx={0,1,0,-1};
        int direction1=0;
        int direction2=0;
        //현수와 개의 위치
        int hy=0,hx=0;
        int py=0,px=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j]==2){
                    hy=i;
                    hx=j;
                }
                if(board[i][j]==3){
                    py=i;
                    px=j;
                }
            }
        }
        while (!isFind){
            answer++;
            //현수
            int nhy = hy+ dy[direction1];
            int nhx= hx+ dx[direction1];
            if(nhy < 0 || nhy >= 10 || nhx < 0 || nhx >= 10 || board[nhy][nhx]==1){
                direction1= (direction1+1) % 4;
            }
            else{
                hy=nhy;
                hx=nhx;
            }
            //개
            int npy = py+ dy[direction2];
            int npx= px+ dx[direction2];
            if(npy < 0 || npy >= 10 || npx < 0 || npx >= 10 || board[npy][npx]==1){
                direction2= (direction2+1) % 4;
            }
            else{
                py=npy;
                px=npx;
            }
            //위치 같은지, 제한시간 지났는지 체크
            if(hy==py && hx==px) isFind=true;
            if(answer>10000){
                answer=0;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}