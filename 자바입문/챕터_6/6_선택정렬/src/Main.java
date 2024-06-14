import java.util.*;
public class Main {
    public int[] solution(int n , int[] arr){
        //6
        //13 5 11 7 23 15
        //선택정렬  1 : 그냥 떠오른대로 푼 방식
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++){
//                if(arr[i] > arr[j]){
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }

        //선택정렬  2 : 1번보다 코드가 더 깔끔하게 나오는듯. 이런 변수 할당방식이 유용해보인다.
        for(int i=0; i<n-1; i++){
            int idx=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[idx]) idx=j;
            }
            int tmp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=tmp;
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


