import java.util.*;
class Edge implements Comparable<Edge>{
//    int v1,v2,cost;
//    public Edge(int v1,int v2,int cost){
//        this.v1=v1;
//        this.v2=v2;
//        this.cost=cost;
//    }
    int v,cost;
    public Edge(int v,int cost){
        this.v=v;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main {
    static int n,m,sum=0;
    static ArrayList<ArrayList<Edge>> list;
    static PriorityQueue <Edge> pQ = new PriorityQueue<>();
    static int [] ch;
    public void solution(int sv, int sc){
        //시작 정점 세팅 1,0
        pQ.offer(new Edge(sv,sc));

        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            //정점을 꺼내면 ch=1
            if(ch[tmp.v]==0){
                ch[tmp.v]=1;
                sum+=tmp.cost;
                for(Edge le : list.get(tmp.v)){
                    //이미 정점이 된 곳은 건들지 않는다
                    if(ch[le.v]==0) pQ.offer(new Edge(le.v, le.cost));
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        //최소 스패닝 트리는 그래프를 트리화 시키는 거라고 이해해도 된다.
        // 프림은 크루스칼 알고리즘과 달리 Union & Find 쓰지않고 pQ사용함
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        //PriorityQueue<Edge>pQ=new PriorityQueue<>();
        n= kb.nextInt();
        m= kb.nextInt();
        //출력 변수 선언
        sum=0;
        //인접리스트 초기화
        list = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        //ch배열 선언
        ch= new int[n+1];
        //Edge 입력
        for(int i=1;i<=m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            //무방향 그래프기에 양쪽 다 넣음
            list.get(a).add(new Edge(b,c));
            list.get(b).add(new Edge(a,c));
        }
        M.solution(1,0);
    }
}


