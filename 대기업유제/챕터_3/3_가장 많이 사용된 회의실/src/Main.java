import java.util.*;
class Solution {
    public int solution(int n, int[][] meetings){
        int answer=0;
        int[] res = new int[n];
        PriorityQueue<int[]> ends = new PriorityQueue<>( (e1,e2)->(e1[0]==e2[0] ?e1[1]-e2[1] : e1[0]-e2[0]) );// 종료시간 빠른순서대로 정렬
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i=0;i<n;i++)rooms.add(i);
        Arrays.sort(meetings,(e1,e2)->e1[0]-e2[0]);
        for(int[] m : meetings){
            //회의실이 사용중이고 끝나는 회의시간보다 다음회의 시작시간이 같거나크면 시간이 지났다고 판단하고
            //진행중인 회의들 종료처리
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) rooms.add(ends.poll()[1]);
            //회의가능한 방이 있으면
            if(!rooms.isEmpty()){
                int room = rooms.pollFirst();
                res[room]++;
                ends.add(new int[]{m[1], room});
            }
            //기다려야하는 경우임. 때문에 종료시간 = (기존 회의 종료시간 + 기다린시간)
            //회의진행 가능한 방이 없으면 진행중인 회의(가장 빨리 끝나는) 종료처리 후 다음 회의
            else{
                int[] e = ends.poll();
                ends.add(new int[]{e[0] + (m[1] - m[0]), e[1]});
                res[e[1]]++;
            }
        }
       // System.out.println(Arrays.toString(res));
        int maxi = 0;
        for(int i = 0; i < n; i++){
            if(res[i] > maxi){
                maxi = res[i];
                answer = i;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}