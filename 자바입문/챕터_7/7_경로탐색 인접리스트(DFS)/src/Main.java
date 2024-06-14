import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int [] ch;
    static int n,m, answer=0;
    //종이에 단계별로 그리면서 결과가 나오는것은 확인했는데 아직 완벽히 이해못함
    public int DFS(int v){
        // 입접리스트 방식
        if(v == n) return answer++;
        else{
            for(int nv : graph.get(v)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
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
        ch = new int [n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        //리스트 필요한 만큼 생성
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<m; i++){
            int row = kb.nextInt();
            int col = kb.nextInt();
            graph.get(row).add(col);
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