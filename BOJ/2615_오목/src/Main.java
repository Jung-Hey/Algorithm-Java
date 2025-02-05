import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static void solve(int[][] board , int target, int[] point ){
        /**
         * 탐색 좌표 - 현 좌표를 기준으로 정방향 역방향 나눠져서 오목 검사
         */
        // 위, 우측위, 우, 우측하
        int [] dx = {-1,-1,0,1};
        int [] dy = {0,1,1,1};
        // 아래, 좌측아래, 좌, 좌측상
        int [] rdx = {1,1,0,-1};
        int [] rdy = {0,-1,-1,-1};
        // 시작 좌표
        int x = point[0];
        int y = point[1];

        // 오목 이어지는 히스토리
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.clear();
            list.add(new Integer[] {x,y});
            int dis; // 탐색을 위해 이동할 간격
            int findNum = 1; // 찾은 돌의 연속
            // 정방향 탐색
            dis=0;
            while (true){
                int nx = x + dx[i] + (dx[i] == 0 ? 0 : dx[i] > 0 ? dis : (0-dis));
                int ny = y + dy[i] + (dy[i] == 0 ? 0 : dy[i] > 0 ? dis : (0-dis));
                dis++; // 탐색할 다음 거리
                if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break; // 인덱스 범위 넘어가면 그 방향 계속 찾을필요 X
                if(board[nx][ny] == 0 || board[nx][ny] != target) break ; // 연속으로 이어지지 않아도 계속 그 방향 찾을 필요 없음
                list.add(new Integer[] {nx,ny});
                findNum++; // 이어짐
            }
            // 역방향 탐색
            dis=0;
            while (true){
                int rnx = x + rdx[i] + (rdx[i] == 0 ? 0 : rdx[i] > 0 ? dis : (0-dis));
                int rny = y + rdy[i] + (rdy[i] == 0 ? 0 : rdy[i] > 0 ? dis : (0-dis));
                dis++; // 탐색할 다음 거리
                if(rnx < 0 || rnx >= 19 || rny < 0 || rny >= 19) break; // 인덱스 범위 넘어가면 그 방향 계속 찾을필요 X
                if(board[rnx][rny] == 0 || board[rnx][rny] != target) break ; // 연속으로 이어지지 않아도 계속 그 방향 찾을 필요 없음
                findNum++; // 이어짐
                list.add(new Integer[] {rnx,rny});
            }
            // 오목이면
            if(findNum==5){
                System.out.println(target); // 승리한 돌 타입 1: 흑돌 2: 백돌
                list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // 정렬
                System.out.println((list.get(0)[0]+1)+" "+ (list.get(0)[1]+1));
                System.exit(0);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        int [][] board = new int[19][19];
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // solve
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int now = board[i][j];
                if(now != 0) solve(board, now, new int[] {i,j}); // 배열, 찾을 돌 타입, 좌표
            }
        }
        // 무승부
        System.out.println(0);
    }
}

