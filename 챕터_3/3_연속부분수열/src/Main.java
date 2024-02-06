import java.util.*;
public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
//        8 6
//        1 2 1 3 1 1 1 2     ==> 3
        // 내가 푼 방식
        int sum=0;
//        for(int i=0;i<n;i++){
//            sum = 0;
//            for(int j=i;j<n;j++){
//                sum+= arr[j];
//                if(sum == k){
//                    answer++;
//                    break;
//                }
//                else if(sum > k){
//                    break;
//                }
//            }
//        }

        //내가 푼 방식 2 : 풀이처럼 O(n)이고 투포인터를 이용함.
//        int lt=0, rt=0;
//        while (lt< n && rt < n){
//            sum+=arr[rt];
//            //맞으면 lt,rt 다음 lt 시작 포인트로 둘 다 맞춰줌
//            if(sum == k){
//                answer++;
//                sum=0;
//                lt++;
//                rt = lt;
//            }
//            //작으면 rt를 이동시켜 더해줌
//            else if(sum < k) rt++;
//            //클경우
//            else{
//                sum=0;
//                lt++;
//                rt=lt;
//            }
//        }
        //풀이에서의 방식 : 투포인터와 윈도우 슬라이딩 방식을 복합적으로 섞은 방식
        int lt=0;
        for(int rt=0; rt<n; rt++){
            sum += arr[rt];
            if(sum == k) answer++;
            while( sum >= k){
                sum -= arr[lt++];
                if(sum == k) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(M.solution(n,k,arr));
    }



}



