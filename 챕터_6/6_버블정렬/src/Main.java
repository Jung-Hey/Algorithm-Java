import java.util.*;
public class Main {
    public int[] solution(int n , int[] arr){
        //6
        //13 5 11 7 23 15

        //버블정렬 1 : 생각나는대로 풂
//        for(int i=0; i<n-1; i++){
//           int cnt=0;
//           for(int j=0+cnt; j<n-1; j++){
//                if(arr[j]>arr[j+1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//                cnt++;
//           }
//        }

        //버블정렬 2 : 1번 방법보다 더 나은방법으로 보인다.
        //왜냐하면 버블정렬은 1회전 될때마다 가장 큰 수가 배열 마지막에 배치되기 때문
        //1번 처럼 j의 탐색시작 범위를 늘리기보다 탐색종료 지점을 줄이는게 더 좋아보인다.
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        for(int j : M.solution(n,arr)) System.out.print(j+" ");


    }
}


