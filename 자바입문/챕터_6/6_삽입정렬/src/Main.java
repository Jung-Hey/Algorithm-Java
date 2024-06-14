import java.util.*;
public class Main {
    public int[] solution(int n , int[] arr){
        //6
        //13 5 11 7 23 15
        //삽입정렬 1 : 생각나는대로 풂
//        for(int i=1; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(arr[i]<arr[j]){
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }

        //삽입정렬 2 : 1번 보다 시간복잡도가 좋은 방법
        for(int i=1; i<n; i++){
            int tmp= arr[i], j;
            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp) arr[j+1]= arr[j]; // 이게 순서대로 밀어내는 코드부분
                else break;
            }
            //카드가 삽입되어야 할 위치에 삽입 j를 부모 for문 에서 선언해야 한다.
            arr[j+1] = tmp;
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


