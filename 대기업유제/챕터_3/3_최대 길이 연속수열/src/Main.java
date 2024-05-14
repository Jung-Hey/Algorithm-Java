import java.util.*;
class Solution {
    public int solution(int[] nums){
//        int answer = 1 , cnt=1;
//        PriorityQueue<Integer> pQ= new PriorityQueue<>();
//        HashSet<Integer> set = new HashSet<>();
//        for(int i : nums){
//            if(!set.contains(i)) pQ.offer(i);//
//            set.add(i);
//        }
//        int N = pQ.poll();
//        while ( !pQ.isEmpty() ){
//            int nextN = pQ.poll();
//            if( N+1 == nextN ){
//                cnt++;
//                N = nextN;
//            }
//            else if( N+1 != nextN ) {
//                cnt = 1;
//                N = nextN;
//            }
//            answer=Math.max(answer,cnt);
//        }
        //풀이에서의 방식 : 우선순위 큐 없이 set으로 시작위치 탐색 후 계산
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums)set.add(i);
        for(int x: set){
            int cnt=0;
            if(set.contains(x-1))continue;
            while (set.contains(x)){
                x++;
                cnt++;
            }
            answer=Math.max(cnt,answer);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}

