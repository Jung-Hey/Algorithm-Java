import java.util.*;
public class Main {
    public void solution(int n) {
        // INP:3
        // OUP:1 2 3
        // 함수가 호출되면 스택프레임에 지역변수,매개변수,복귀주소가 스택에 push된다.
        // n이 감소하다 0이 되어 리턴되면 스택에 담겨있던 복귀주소와 매개변수 처리로 인해 스택 최상단인 1부터 출력된다.
        // 이 개념을 알고있어야 추후 DFS와 같은 알고리즘을 학습할때 헤매지 않는다.
        if(n==0) return;
        else{
            solution(n-1);
            System.out.print(n+" ");

        }
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = 5;
        M.solution(n);
    }
}


