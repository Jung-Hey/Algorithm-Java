import java.util.*;
class Solution {
    public int solution(int[][] routes, int s, int e){
        int answer = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        int[] ch = new int[routes.length];
        // Hashing
        int n = routes.length;
        for(int i = 0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }
        //
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int x = q.poll(); // 1
                for(int t :graph.get(x)){// t는 x(1)번 역이 있는 호선들을 출력
                    if(ch[t]==1) continue;
                    ch[t]=1;
                    for(int ne : routes[t] ){
                        q.offer(ne); // 호선에 관련한것 추가
                        if(ne == e) return L;
                    }
                }
            }
            L++;
        }
        answer = -1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));

    }
}