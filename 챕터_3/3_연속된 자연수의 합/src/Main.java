import java.util.*;
public class Main {
    public int solution(int n) {
        int answer = 0 , sum=0;
        int limit = n/2+1;
        int [] arr = new int[limit];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int lt=0, rt=1;
        sum += arr[lt];
        while (lt<limit && rt<limit){
            sum+= arr[rt++];
            if(sum == n) answer++;
            while (sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
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



