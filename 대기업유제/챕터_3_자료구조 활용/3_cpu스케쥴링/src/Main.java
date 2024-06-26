//CPU 스케쥴링
import java.util.*;

class Solution {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        ArrayList<Integer> res= new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i=0;i< tasks.length;i++) programs.offer(new int[]{ tasks[i][0], tasks[i][1], i });
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ft=0, idx=0;
        //pq와 programs 둘 다 빌 때까지 반복
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) ft = Math.max(ft, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= ft){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            ft = ft + ex[0];
            res.add(ex[1]);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));    }
}