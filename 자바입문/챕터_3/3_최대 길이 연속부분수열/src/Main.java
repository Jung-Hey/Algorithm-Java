import java.util.*;
public class Main {
    public int solution(int n , int k , int [] arr){
        int answer = 0;
        int cnt=0;
        // 14 2
        // 1 1 0 0 1 1 0 1 1 0 1 1 0 1  ==> 8
        int lp=0;
        for(int rp=0; rp<n; rp++){
            if(arr[rp]==0)cnt++;
            while(cnt>k){
                if(arr[lp]==0)cnt--;
                lp++;
            }
            answer = Integer.max(answer, rp-lp+1); // rp-lp+1 : 연속부분수열의 길이

        }


        return answer;

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]= kb.nextInt();
        System.out.println(M.solution(n,k,arr));
    }
}


