import java.util.*;
class Solution {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] range = new int [n+1][2];
        for(int i=0; i< nums.length; i++){
            range[i][0] = Math.max(0, i-nums[i]);
            range[i][1] = Math.min(n, i+nums[i]);
        }
        int s=0, e=0, idx=0;
        while (idx < range.length){
            while (idx < range.length && s >= range[idx][0]){
                e = Math.max(e,range[idx][1]);
                if(e==n) return answer+1;
                idx++;
            }
            answer++;
            if(e==n) return answer;
            if(s == e) return -1;
            s=e;

        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}