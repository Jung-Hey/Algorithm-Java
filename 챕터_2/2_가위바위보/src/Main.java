import java.util.*;

public class Main {
    public ArrayList<String> solution( int[] arr_A , int[] arr_B){
        ArrayList<String> answer = new ArrayList<>();
        //내가 푼 방식 ==> 겁나 비효율적임
//        for(int i=0; i<arr_A.length; i++){
//            //A가 1(가위를 냈을때)
//            if(arr_A[i] == 1){
//                if(arr_B[i] == 2) answer.add("B");
//                else if(arr_B[i] == 3) answer.add("A");
//                else answer.add("D");
//            }
//            //A가 2(바위를 냈을때)
//            else if(arr_A[i] == 2){
//                if(arr_B[i] == 1) answer.add("A");
//                else if(arr_B[i] == 3) answer.add("B");
//                else answer.add("D");
//            }
//            //A가 3(보를 냈을때)
//            else if(arr_A[i] == 3){
//                if(arr_B[i] == 1) answer.add("B");
//                else if(arr_B[i] == 2) answer.add("A");
//                else answer.add("D");
//            }
//        }
        //풀이에서의 방식
        for(int i=0; i<arr_A.length; i++) {
            if(arr_A[i] == arr_B[i]) answer.add("D");
            else if(arr_A[i]== 1 && arr_B[i]== 3) answer.add("A");
            else if(arr_A[i]== 2 && arr_B[i]== 1) answer.add("A");
            else if(arr_A[i]== 3 && arr_B[i]== 2) answer.add("A");
            else answer.add("B");
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr_A = new int[n];
        for(int i = 0; i < n; i++ ){
            arr_A[i] = kb.nextInt();
        }
        int [] arr_B = new int[n];
        for(int i = 0; i < n; i++ ){
            arr_B[i] = kb.nextInt();
        }
        for(String c : M.solution(arr_A,arr_B)){
            System.out.println(c);
        }
        ;
    }

}