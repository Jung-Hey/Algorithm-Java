import java.util.*;
public class Main {
    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=n; i++) que.offer(i);
        while (que.size() > 1){
            for(int i=1; i<k; i++) que.offer(que.poll());
            que.poll();
        }
        answer = que.poll();

        return answer;

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.print(M.solution(n,k));
    }
}


