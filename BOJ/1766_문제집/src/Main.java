import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //문제 수
        int m = sc.nextInt(); // 우선순위 문제 수
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add( new ArrayList<>() );
        }
        int[] degree = new int[n];
        for(int i=0; i<m; i++){
            //a가 b보다 먼저
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a-1).add(b-1);
            degree[b-1]++;
        }
        //System.out.println(Arrays.toString(indegree));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(degree[i]==0){
                pq.offer(i);
            }
        }
        // 큐가 빌 떄까지
        while (!pq.isEmpty()){
            int pre = pq.poll();
            sb.append(pre+1).append(" ");
            //인접 그래프 탐색
            for(int x : graph.get(pre)){
                // 감소시킨 값이 0이면 바로 풀 수 있는 상태이기 때문에 큐에 넣어준다.
                degree[x]--;
                if(degree[x] == 0) pq.offer(x);
            }
        }
        // 정답 출력
        System.out.println(sb);
    }
}