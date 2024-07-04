
import java.util.*;
class Main {
    static int n;
    static char[][] board;

    static void star(int y, int x, int N, boolean blank) {
        // 빈칸처리
        if(blank){
            for(int i=y; i<y+N; i++){
                for(int j=x; j<x+N; j++){
                    board[i][j]=' ';
                }
            }
            return;
        }
        //더 이상 쪼갤 칸이 없으면
        if(N==1){
            board[y][x]='*';
            return;
        }
        //
        int size = N/3;
        int cnt=0;
        for(int i=y; i<y+N; i+=size) {
            for (int j = x; j < x + N; j+=size) {
                cnt++;
                if(cnt==5) star(i, j, size, true);
                else{
                    star(i, j, size, false);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        //solve
        star(0, 0, n, false);
        //output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);


    }
}