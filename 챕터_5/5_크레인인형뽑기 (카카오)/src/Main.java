import java.util.*;
public class Main {
    public int solution(int n, int[][] board, int m, int [] moves ){
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        //moves배열 탐색
        for(int i=0;i<m;i++){
            //board 배열 탐색
            for(int j=0;j<n;j++){
                int mp = moves[i]-1;
                if(board[j][mp] != 0 ){
                    //0인거 건너뛰고 바구니(스택)에 넣음
                    if(stk.size()>0 && stk.peek() == board[j][mp] ){
                        stk.pop();
                        answer+=2;
                    }
                    else{
                        stk.push(board[j][mp]);
                    }

                    board[j][mp] = 0; //다음에 또 안잡히도록 초기화

                    //비효율적이라 for문 안쓰는쪽으로 위처럼 고침
                    //바구니에 쌓인 인형이 동일한게 겹치면 터짐
//                    int stk_len = stk.size()-1;
//                    if(stk.size()>1){
//                        for(int z=stk_len; z>=1; z--){
//                            if(stk.get(z) == stk.get(z-1)){
//                                stk.pop();
//                                stk.pop();
//                                answer+=2;
//                                break;
//                            }
//                        }
//                    }
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

        int [][] board = new int[n][n];
//        for(int i=n-1;i>=0;i--){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = kb.nextInt();
            }
        }

        int m = kb.nextInt();
        int [] moves = new int[m];
        for(int i=0;i<m;i++){
            moves[i]= kb.nextInt();
        }
        System.out.print(M.solution(n,board,m,moves));
    }
}


