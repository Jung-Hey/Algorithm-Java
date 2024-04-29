import java.util.*;
class Solution {
    public int solution(int[] nums){
        // nums배열에서 봉우리를 찾아 봉우리 인덱스를 따로 저장
        // 해당 봉우리인덱스를 lt,rt로 길이 탐색 후 높은것을 저장
        int answer = 0;
        int len = nums.length;
        ArrayList<Integer> peeks = new ArrayList<>();
        for(int i=1;i<len-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) peeks.add(i);
        }
        for(int p : peeks){
            int cnt=1;
            int lt = p;
            int rt = p;
            while (lt-1>=0 && nums[lt]> nums[lt-1]){
                lt--;
                cnt++;
            }
            while (rt+1<len && nums[rt]> nums[rt+1]){
                rt++;
                cnt++;
            }
            answer=Math.max(answer,cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}