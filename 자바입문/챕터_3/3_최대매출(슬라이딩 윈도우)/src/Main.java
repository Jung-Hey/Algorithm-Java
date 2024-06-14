import java.util.*;
public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;

        //시간초과 탈락됨
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n-k; i++) {
//            int tmp=0;
//            for (int j = i; j < i+k; j++) {
//                tmp+=arr[j];
//            }
//            if(max<tmp)max=tmp;
//            tmp=0;
//        }
//        answer=max;

        //풀이 : 슬라이딩 윈도우 방식 O(n)
        int sum=0;
        //최초 윈도우 생성
        for(int i=0;i<k;i++) sum+= arr[i];
        answer=sum;
        //*** 슬라이딩
        for(int i=k; i<n; i++){
            sum+= (arr[i]-arr[i-k]);
            answer = Math.max(sum,answer);
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



