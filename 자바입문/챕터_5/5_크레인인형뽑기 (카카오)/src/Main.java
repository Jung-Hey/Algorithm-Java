import java.util.*;
public class Main {
    public int  solution(int n, int[][] board, int w, int [] works){
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<w; i++){
            int wk = works[i]-1;
            for(int j=0; j<n; j++){
                //크레인으로 스택에 넣어야 함
                if((board[j][wk]) != 0){
                    int doll = board[j][wk];
                    board[j][wk] = 0;
                    //스택이 안비었으면 넣을때 중복되는거 터지도록 함
                    if(!stk.empty()){
                        if(doll == stk.peek()){
                            stk.pop();
                            answer+=2;
                        }
                        else stk.push(doll);
                    }
                    //비었으면 그냥 넣음
                    else stk.push(doll);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [][] board = new int [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = kb.nextInt();
            }
        }
        int w = kb.nextInt();
        int [] works = new int[w];
        for(int i=0; i<w; i++) works[i]= kb.nextInt();
        System.out.print(M.solution(n,board,w,works));





    }
}
