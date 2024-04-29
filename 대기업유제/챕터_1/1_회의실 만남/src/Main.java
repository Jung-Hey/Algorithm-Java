import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] exit){
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        int inIdx=0,outIdx=0;
        q.offer(enter[inIdx++]);
        while (!q.isEmpty()){
            if(q.size()>1)System.out.println(q.size()+" 명 있음");
            if(q.contains(exit[outIdx])){
                System.out.println("poll : "+exit[outIdx] );
                q.remove(exit[outIdx++]);
            }
            else{
                q.offer(enter[inIdx++]);
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        //System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        //System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        //System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        //System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}