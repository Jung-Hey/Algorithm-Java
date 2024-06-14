//import java.util.*;
//
//public class Main {
//    public int solution(int n,int[][] arr){
//        int answer=0, max=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            int cnt=0;
//            for(int j=0;j<n;j++) {
//                for(int k =0;k<5;k++) {
//                    if(arr[i][k] == arr[j][k]){
//                        cnt++;
//                        break;
//                    }
//                }
//            }
//            if(max<cnt){
//                max=cnt;
//                answer= i+1;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int [][] arr = new int[n][n];
//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < 5; j++) {
//                arr[i][j] = kb.nextInt();
//            }
//        }
//        System.out.print(T.solution(n,arr));
//        }
//
//
//}
//

//위에거는 맞게나오는데 채점사이트에서만 런타임오류라고 뜸. 질문등록한 상태
import java.util.*;

public class Main {
    public int solution(int n,int[][] arr){
        int answer=0, max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1;j<=n;j++) {
                for(int k =1;k<=5;k++) {
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(max<cnt){
                max=cnt;
                answer= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [][] arr = new int[n+1][6];
        for(int i=1; i<=n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n,arr));
    }


}


