import java.util.*;
class Main {
    static int n;
    static int[][] arr;
    static int blueCnt;
    static int whiteCnt;
    // 현재 파티션의 컬러가 같은지 체크한다.
    public static boolean isPass(int y, int x, int size) {
        int color = arr[y][x];	//검사 기준이 되는 색상
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                // 색상이 같이 않다면 false
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        // 영역이 모두 한 색상이면 true
        return true;
    }
    public static void divideArea(int y, int x, int size) {
        if(isPass(y,x,size)){
            if(arr[y][x]==1) blueCnt++;
            else whiteCnt++;

            return;
        }
        int halfSize = size/2;
        divideArea(y,x,halfSize);
        divideArea(y,x+halfSize,halfSize);
        divideArea(y+halfSize,x,halfSize);
        divideArea(y+halfSize,x+halfSize,halfSize);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        blueCnt=0;
        whiteCnt=0;
        //input
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        divideArea(0, 0, n);
        //output
        System.out.println(whiteCnt);
        System.out.println(blueCnt);



    }
}