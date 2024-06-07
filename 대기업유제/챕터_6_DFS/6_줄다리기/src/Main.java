import java.util.*;
class Solution {
    static int answer;
    Stack<Integer> stk;
    void dfs(int l, String tmp, int[][] relation){
        if(l==7){
            answer++;
        }
        else{
            for(int i=1;i<=7;i++){
                if(!stk.isEmpty() && relation[stk.peek()][i] == 1)  continue;
                if(ch[i]==0){
                    ch[i]=1;
                    stk.push(i);
                    dfs(l+1, tmp+String.valueOf(i), relation);
                    ch[i]=0;
                    stk.pop();
                }
            }
        }

    }
    static int[] ch;
    public int solution(int[][] fight){
        answer = 0;
        ch= new int[8];
        stk = new Stack<>();
        int[][] relation = new int[7+1][7+1];
        for(int[] r : fight){
            relation[r[0]][r[1]]=1;
            relation[r[1]][r[0]]=1;
        }

        dfs(0,"",relation);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
