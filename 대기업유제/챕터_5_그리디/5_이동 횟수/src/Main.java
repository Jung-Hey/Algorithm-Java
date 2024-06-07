import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int lt=0, rt= nums.length-1;
        while (lt <= rt){
            if(nums[lt]+nums[rt] > 5){
                rt--;
                answer++;
            }
            else{
                answer++;
                lt++;
                rt--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}