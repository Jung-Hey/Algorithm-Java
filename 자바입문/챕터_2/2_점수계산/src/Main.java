import java.util.*;

public class Main {
    public int solution(int n, int[] arr){
        int answer = 0;
        int cnt = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == 1){
                if(cnt >0) answer += cnt;
                answer+=1;
                cnt+=1;
            }
            else cnt = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();
        System.out.println(M.solution(n,arr));

    }

}