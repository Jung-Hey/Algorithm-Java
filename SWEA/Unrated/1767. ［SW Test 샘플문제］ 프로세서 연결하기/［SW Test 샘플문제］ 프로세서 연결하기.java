import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int totalMinLen;
    static int totalUsedCell;
    static List<int[]> cellList;
    static int [][] arr;
    static int n;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()), t=0;
        StringBuilder sb = new StringBuilder();
        cellList = new ArrayList<>();
        while (t++ < tc){
            totalMinLen = Integer.MAX_VALUE;
            totalUsedCell=0;
            cellList.clear();
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                arr[i] = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 셀이면
                    if(arr[i][j] == 1){
                        if( (i==0 || i==n-1)  || (j==0 || j==n-1) ) continue; // 가장 자리는 이미 연결됨
                        cellList.add(new int [] {i,j});
                    }
                }
            }
            connectPower(0,0,0);
            sb.append("#").append(t).append(" ").append(totalMinLen).append("\n");
        }
        System.out.println(sb);

    }

    private static void connectPower(int level , int useCnt, int len) {
        if(level == cellList.size()){
            // 셀을 많이 사용했거나
            if(useCnt > totalUsedCell || (useCnt==totalUsedCell &&  totalMinLen > len) ){
                totalUsedCell = useCnt;
                totalMinLen = len;
            }
        }
        else{
            connectPower(level+1, useCnt, len); // 1. 연결하지 않음
            int [] nowCell = cellList.get(level);
            for (int dir = 0; dir < 4; dir++) {
                int lineLen = getLen(dir, nowCell);
                // 2~5. 가능하면 4방 연결
                if(  lineLen > 0 ){
                    setLine(nowCell, dir, lineLen, -1); // 선긋기
                    connectPower(level+1, useCnt+1, len+lineLen); // 다음 셀 재귀 진행
                    setLine(nowCell, dir, lineLen, 0); // 선긋기 백트래킹
                }
            }

        }

    }

    // 선 긋기
    private static void setLine(int[] nowCell, int dir, int lineLen, int value) {
        int nx = nowCell[0];
        int ny = nowCell[1];
        for (int i = 0; i < lineLen; i++) {
            nx += dx[dir];
            ny += dy[dir];
            arr[nx][ny] = value;
        }
    }
    // 셀과 전원선까지의 거리
    private static int getLen(int dir, int[] nowCell) {
        int dis = 0;
        int nx = nowCell[0];
        int ny = nowCell[1];
        while (true){

            nx += dx[dir];
            ny += dy[dir];
            // 연결가능하면
            if( (nx < 0 || nx >= n || ny < 0 || ny >= n) ) return dis;
            //if(nx<0 || nx>=n || ny<0 || ny>=n) return dis;
            // 연결 불가능 (셀이나 간선 만나는 경우)
            else if(arr[nx][ny] != 0) return 0;
            dis++;
        }
    }


}