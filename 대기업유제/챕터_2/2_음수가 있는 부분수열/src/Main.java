import java.util.*;
class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;
        // 내가 푼 코드 8분 : 음수때문에 투포인터 안된다 판단 후 단순 중첩 반복문
        //        int len=nums.length;
        //        for(int i=0;i<len;i++){
        //            int sum=nums[i];
        //            if(sum==m)answer++;
        //            for(int j=i+1;j<len;j++){
        //                sum+=nums[j];
        //                if(sum==m)answer++;
        //            }
        //        }
        //풀이 해싱으로 처리
        HashMap<Integer,Integer>map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-m))answer+=map.get(sum-m);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}