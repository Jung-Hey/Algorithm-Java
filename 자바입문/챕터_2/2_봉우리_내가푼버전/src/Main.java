import java.util.*;

public class Main {

    public boolean isPass(int i,int j ,int value, int[][] arr){
        // 11의 경우 상하좌우 (01, 10, 12, 21) 탐색해야함
        if(arr[i-1][j] >= value) return false;
        if(arr[i][j-1] >= value) return false;
        if(arr[i+1][j] >= value) return false;
        if(arr[i][j+1] >= value) return false;
        return true;
    }
    public int solution(int n,int[][] arr){
        int answer = 0;
        //격자판 초기화 5*5 => 7*7
        int [][] format_Arr = new int[n+2][n+2];
        for(int x=1; x<=n; x++){
            for(int y=1; y<=n; y++){
                format_Arr[x][y] = arr[x-1][y-1];
            }
        }
        // 7*7 격자판일 경우 상하좌우가 0으로 초기화되기 때문에
        // x,y범위는 탐색을 1~5 까지 탐색하면 된다
        for(int i=1;i<format_Arr.length-1;i++){
            for(int j=1;j<format_Arr.length-1;j++){
                if(isPass(i,j,format_Arr[i][j],format_Arr)) answer+=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(M.solution(n,arr));
    }
}

