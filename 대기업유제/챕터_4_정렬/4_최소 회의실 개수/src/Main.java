import java.util.*;
class Solution {
    public int solution(int[][] meetings){
        int answer = 0 , cnt=0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] m : meetings){
            int in = m[0];
            int out = m[1];
            list.add(new int[]{in,1});
            list.add(new int[]{out,2});
        }
        list.sort( (a,b) ->(a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]) );
        for(int[] m : list){
            if(m[1]==1) cnt++;
            else cnt--;
            answer= Math.max(answer,cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 6},{5, 7}}));
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}