import java.util.*;
class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;
        // 2명 이하일때는 투포인터 생각해볼것
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int lt=0, rt= nums.length-1;
        while (lt <= rt){
            if(nums[lt]+nums[rt] > m){
                answer++;
                rt--;
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
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}