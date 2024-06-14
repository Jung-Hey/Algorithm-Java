import java.util.*;
public class Main {
    public int solution(int n) {
        // INP:5
        // OUP:120
        if(n==1) return 1;
        else return n * solution(n-1);
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(M.solution(n));

    }
}


