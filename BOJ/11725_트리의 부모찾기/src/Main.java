import java.util.*;
class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int [] parent;
    static int [] ch;
    public static void dfs(int node){
        ch[node] = 1; //방문
        for(int nv : graph.get(node)){
            if(ch[nv]==0){ // 방문 안한노드만 탐색
                parent[nv]=node; // 부모 노드 저장
                //System.out.println(nv+" 의 부모는  "+node);
                dfs(nv);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        graph = new ArrayList<>();
        int n = sc.nextInt();
        parent = new int[n+1];
        ch = new int[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i=0; i<n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 양방향 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //트리의 루트노드는 1이므로 1부터 dfs재귀
        dfs(1);
        // output : 2~n 의 부모 출력
        for(int i=2; i<=n; i++) System.out.println(parent[i]);
    }
}