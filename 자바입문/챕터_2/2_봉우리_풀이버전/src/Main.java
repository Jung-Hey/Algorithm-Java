import java.util.*;

public class Main {
    public int solution(int n,int[][] arr){
        int answer = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flag = true;
                for(int k=0;k<dx.length;k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n  && ny >= 0 && ny < n && arr[i][j] <= arr[nx][ny]){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
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

