import java.util.*;
public class Main {
    public void solution(int n) {
        // INP:11
        // OUP:1011
        if(n == 0) return;
        else{
            solution(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        M.solution(n);

    }
}


