import java.util.*;

public class Main {
    static int [][] graph;
    static int [] ch;
    static int answer=0;
    static int n;
    static int m;
    //종이에 단계별로 그리면서 결과가 나오는것은 확인했는데 아직 완벽히 이해못함
    public int DFS(int v){
        // 입접행렬 방식
        if(v == n) return answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && ch[i] == 0){
                    ch[i]=1; // if 1->2 로 이동했는데 다시 2->1이 되는 무한반복을 만들지 않기 위해 체크
                    DFS(i);
                    ch[i]=0; // 백트래킹을 위한 처리
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 노드 수
        m = kb.nextInt(); // 간선 수
        graph = new int [n+1][n+1];
        ch = new int [n+1];
        for(int i=0; i<m;i++){
            int row = kb.nextInt(); // 행
            int col = kb.nextInt(); // 열
            graph[row][col] = 1;
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);

    }
}
//입력
//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5