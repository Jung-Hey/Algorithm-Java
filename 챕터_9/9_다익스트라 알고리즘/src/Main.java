import java.util.*;
class Edge implements Comparable<Edge> {
    int vex;
    int cost;
    Edge(int to,int cost){
        this.vex=to;
        this.cost=cost;
    }
    //ArrayList에서는 Collections.sort(변수명)해야 적용되지만
    //우선순위 큐에서는 poll()하면 자동으로 처리됨.
    //가장 짧은 노드에서 퍼져나가야 최단거리를 구하는 알고리즘이라고 할 수 있다(중요)
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main {
    static int n,m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;
    public void solution(int start){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start,0));// 출발 정점 초기화
        dis[start]=0;// 출발 정점 초기화
        //우선순위 큐가 빌 때까지
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex; //간선
            int nowCost = tmp.cost; //가중치
            if(nowCost>dis[now]) continue;//이미 최소비용인것은 구할필요 없음
            //정점의 간선 탐색
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;//최소비용일 경우 최신화
                    pQ.offer(new Edge(ob.vex,nowCost+ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        dis = new int[n+1];//각 정점의 최소이동거리 배열
        Arrays.fill(dis, Integer.MAX_VALUE);//배열 값 초기화
        graph = new ArrayList<ArrayList<Edge>>();//각 정점 별 가중치 정보
        for(int i=0;i<=n;i++) graph.add(new ArrayList<Edge>());//정점 수 만큼 할당
        for(int i=0;i<m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        M.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }

    }
}


