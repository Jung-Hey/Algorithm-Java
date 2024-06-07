import java.util.*;
class Solution {
    public void dfs(int l,int s, int n, int[][] cans){
        if(l==n/2){
            //System.out.println(Arrays.toString(pm));
            HashSet<Integer> set = new HashSet<>();
            int total1 = 0; // 백
            for(int i : pm) set.add(i); // 백 조합
            int total2 = 0; // 흑
            for(int i=0; i<n; i++){
                if(set.contains(i)) total1 += cans[i][0];
                else total2 += cans[i][1];
            }
            answer = Math.min(answer, Math.abs(total1-total2));
        }
        else{
            for(int i=s; i<n; i++){
                pm[l]=i;
                dfs(l+1,i+1,n, cans);
            }
        }
    }
    static int[] pm;
    static int answer;
    public int solution(int[][] cans){
        int n = cans.length;
        answer = Integer.MAX_VALUE;
        pm = new int[n/2];
        dfs(0,0,n,cans);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
