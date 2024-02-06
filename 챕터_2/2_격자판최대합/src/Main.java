import java.util.*;

public class Main {
    public int solution(int n,int[][] arr){
        int answer = -2147000000;
        int sum1=0, sum2=0;
        //각 행, 각 열, 대각선 중 가장 큰 수
        //1. 각 행 , 각 열
        for(int i=0;i<n;i++){
            sum1=0;sum2=0;
            for(int j=0; j<n;j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }


        sum1=0;sum2=0;
        //3. 각 대각선
        for(int i=0;i<n;i++){
            sum1+= arr[i][i];
            sum2+= arr[i][n-i-1];
        }
        answer = Math.max(answer,sum1);
        answer = Math.max(answer,sum2);

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

