import java.util.*;
class Edge implements Comparable<Edge>{
    int v1,v2,cost;
    public Edge(int v1,int v2,int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main {
    static int n,m;
    static int[] unf;
    public int find(int v){
        if(v==unf[v]) return v;
        // *중요: return find(unf[v]); 정답 출력되지만 아래와 같이 써야 경로 압축됨.
        else return  unf[v]=find(unf[v]);
    }
    public void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args) {
        //최소 스패닝 트리는 그래프를 트리화 시키는 거라고 이해해도 된다.
        //방법1: Edge 클래스 만든다.v1 v2 cost, list로 m번 입력받고 cost 오름차순 정렬
        //방법2: list로 Edge정보 꺼내면서 연결된 정점 아니면 sum에 cost 누적. 이미 연결되었으면 넘어감
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        ArrayList<Edge> list = new ArrayList<>();
        //PriorityQueue<Edge>pQ=new PriorityQueue<>();
        n= kb.nextInt();
        m= kb.nextInt();
        //출력 변수 선언
        int sum=0;
        //각 배열 초기화
        unf=new int[n+1];
        for(int i=1;i<=n;i++) unf[i]=i;
        //Edge 입력
        for(int i=1;i<=m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            list.add(new Edge(a,b,c));
        }
        //cost 오름차순 정렬
        Collections.sort(list);
        //간선정보를 담은 list 탐색
        int edge_Cnt=0;
        for(int i=0;i<m;i++){
            if(edge_Cnt==n-1) break;//트리의 간선수는 n-1개이기 때문에 더 돌 필요없다
            Edge tmp = list.get(i);
            //간선정보를 읽어,정점끼리 연결되어 있지않으면 연결 후 sum에 누적
            if(M.find(tmp.v1)!=M.find(tmp.v2) ) {
                M.union(tmp.v1, tmp.v2);
                sum += tmp.cost;
                edge_Cnt++;
            }
        }
        System.out.println(sum);
    }
}


