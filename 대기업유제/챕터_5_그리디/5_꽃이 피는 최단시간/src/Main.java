import java.util.*;
class Solution {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        int[][] line = new int[n][2];
        for(int i=0;i<n;i++){
            line[i][0] = plantTime[i];
            line[i][1] = growTime[i];
        }
        //자라나는 기간 오름차순
        Arrays.sort(line, (a,b)->(b[1]-a[1]));
        for(int i=0, s=0,e=0; i<n; i++){
            e = s + line[i][0] + line[i][1];
            answer = Math.max(answer,e);
            s += line[i][0];
            //System.out.println(s+" "+e);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}