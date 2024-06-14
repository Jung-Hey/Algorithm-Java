import java.util.*;

public class Main {
    //인접리스트 선언
    static ArrayList<ArrayList <Integer>> graph;
    static int [] ch,dis;
    static int n,m;
    public void BFS(int v){
        //1에서 각 정점으로 가는 최소 간선 수를 구해라
        ch[v]=1;// 방문한걸로 처리
        dis[v]=0; // 거리 초기화
        //BFS이기 때문에 큐를 사용
        Queue<Integer>Q = new LinkedList<>();
        Q.offer(v);
        while (!Q.isEmpty()){
            int cv = Q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    Q.offer(nv);
                    dis[nv]= dis[cv]+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();//정점 수
        m = kb.nextInt();//간선 수
        ch = new int[n+1];
        dis = new int[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<m;i++){
            int row = kb.nextInt();
            int col = kb.nextInt();
            graph.get(row).add(col);
        }
        T.BFS(1);
        for(int i=2; i<=n; i++)System.out.println(i+" : "+dis[i]);
    }
}

//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5