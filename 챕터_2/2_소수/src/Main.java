import java.util.*;

public class Main {
    public int solution(int n){
        int answer = 0;
        //에라토스테네스 체 방식 (그게 젤 빠르다네..)
        int[] arr = new int[n+1];
        for(int i=2; i<=n; i++){
            if(arr[i] == 0) answer++;
            for(int j=i; j<=n; j=i+j) arr[j] = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(M.solution(n));



    }

}