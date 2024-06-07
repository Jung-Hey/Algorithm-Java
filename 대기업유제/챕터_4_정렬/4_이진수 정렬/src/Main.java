import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int [][]binaryNums= new int[nums.length][2];
        int idx=0;
        for(int n : nums){
            int len = Integer.toBinaryString(n).replace("0","").length();
            binaryNums[idx][0] = n;
            binaryNums[idx++][1] = len;
        }
        Arrays.sort(binaryNums,(a,b)->( a[1]==b[1] ? a[0]-b[0] : a[1]-b[1] ) );
        for(int i=0;i< nums.length;i++) answer[i] = binaryNums[i][0];

        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc= new Scanner(System.in);
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}