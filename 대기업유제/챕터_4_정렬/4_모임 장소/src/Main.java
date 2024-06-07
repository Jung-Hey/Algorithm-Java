import java.util.*;
class Solution {
    class point{
        int y;
        int x;
        point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    public int solution(int[][] board){
        int answer=0 , cnt=0;
        int len = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(board[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);
        int avgY = row.get(row.size()/2);
        int avgX = col.get(row.size()/2);
        for(int i=0;i<row.size();i++){
            answer+= Math.abs(avgY-row.get(i)) + Math.abs(avgX-col.get(i));
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}