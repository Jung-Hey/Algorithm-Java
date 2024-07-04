import java.util.*;
class Main {
    static ArrayList<ArrayList<Integer>> graph;
    public static int getLinkedCount(int[] ch,int n){
        Queue<Integer> q = new LinkedList<>();
        int answer=0;
        // 1~n 정점 다 탐색
        for(int i=1; i<=n; i++){
            // 방문 안했으면 방문처리 후 answer증가. 그리고 해당 정점과
            // 연결된 정점 모두 방문
            if(ch[i]==0){
                ch[i]=1;
                answer++;
                q.offer(i);
                while (!q.isEmpty()){
                    int x = q.poll();
                    for(int nx : graph.get(x)){
                        if(ch[nx]==0){
                            ch[nx]=1;
                            q.offer(nx);
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 요소의 개수
        int m = sc.nextInt(); // 간선 개수
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        // 무방향 그래프
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 접근 제어 배열
        int [] ch = new int[n+1];
        //output
        System.out.println(getLinkedCount(ch,n));

    }
}