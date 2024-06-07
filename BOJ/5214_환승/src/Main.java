import java.util.*;
class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        int N = sc.nextInt();//1~N개의 역
        int K = sc.nextInt(); // 한개의 하이퍼튜브의 역 개수
        int M = sc.nextInt();//하이퍼튜브 수
        // 하이퍼루프도 노드로 보자: x번째 하이퍼루프를 N+x index에 할당
        for (int i = 0; i <= N+M; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[N+1+M];
        int[] dis = new int[N+1+M];
        // 인접 리스트 구현
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                int temp = sc.nextInt();
                graph.get(temp).add(N+i+1);
                graph.get(N+i+1).add(temp);
            }
        }
        // BFS
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        ch[1] = 1;
        dis[1] = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++){
                int x = q.poll();
                // x=1 , 1번역에 속한 하이퍼튜브 nx = 10,11  (0,1번쨰 하이퍼튜브)
                for (int nx: graph.get(x)) {
                    if (ch[nx]==1) continue;
                    ch[nx] = 1;// {10,11} , {2,3,4,5} , {12,13} , {6,7} , {14}, {8,9}
                    dis[nx] = dis[x]+1;
                    q.offer(nx);
                }
            }
        }
        //System.out.println(distance[N]);
        System.out.println(ch[N]==1 ? dis[N]/2 + 1: -1);
    }
}