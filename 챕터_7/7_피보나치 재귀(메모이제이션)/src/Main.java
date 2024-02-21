import java.util.*;
public class Main {
    static int[] fibo;
    public int solution(int n) {
        // INP:10
        // OUP:1 1 2 3 5 8 13 21 34 55
        // 트리구조로 그림을 그려서 이해하면 쉬움

        //일반적으로 여기서 끝내는경우가 많은데, 이렇게 끝내면 n의 값이 커지면 너무 오래 걸린다.
        //        if(n==1)return 1;
        //        else if(n==2) return 1;
        //        else return solution(n-2)+solution(n-1);

        // 그래서 배열을 fibo 배열을 추가,메모이제이션을 통해 더욱 시간 단축
        if(fibo[n] != 0 ) return fibo[n]; // *** 이 라인 중요
        else if(n==1)return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n] = solution(n-2)+solution(n-1);
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        M.solution(n);
        for(int i=1; i<=n; i++)System.out.print(fibo[i] +" ");;

    }
}


