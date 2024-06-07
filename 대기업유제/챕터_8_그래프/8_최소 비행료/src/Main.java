import java.util.*;
class Edge implements Comparable<Edge>{
    int vex,cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
class Solution {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        int [] dis = new int[n];
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int[] f : flights){
            list.get(f[0]).add(new Edge(f[1], f[2]));
        }
        //PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Edge> pq = new LinkedList<>();
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0; //현수위치
        pq.offer(new Edge(s,0));
        int L=0;
        while (!pq.isEmpty()){
            int len = pq.size();
            for(int i=0;i<len;i++){
                Edge tmp = pq.poll();// 0 0
                int now = tmp.vex;
                int nowCost = tmp.cost;
                for(Edge ne : list.get(now)){
                    if(dis[ne.vex] > nowCost + ne.cost ){
                        dis[ne.vex] = nowCost + ne.cost;
                        pq.offer(new Edge(ne.vex, ne.cost+nowCost));
                    }
                }
            }
            L++;
            if(L>k) break;
        }
        //System.out.println(Arrays.toString(dis));

        answer = dis[e]==Integer.MAX_VALUE ? -1 : dis[e];
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}