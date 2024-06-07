import java.util.*;
class Solution {
    static LinkedList<String> tmp ;
    static int answer;
    //내가 푼 코드
//    public void dfs(int l, String s){
//        if(l == s.length()){
//            for(String str : tmp)System.out.print(str+" ");
//            System.out.println();
//            answer++;
//        }
//        else{
//            for(int i=l; i<s.length(); i++){
//                String num = s.substring(l, i+1);
//                if( !(Integer.parseInt(num) >= 1 && Integer.parseInt(num) <= 26) ) return;
//                tmp.offer(num);
//                dfs(i+1 , s);
//                tmp.pollLast();
//            }
//        }
//    }
    //풀이코드 (메모이제이션)
    static int[] dy;
    public int dfs(int l, String s){
        if(dy[l] > 0) return dy[l];
        if(l < s.length() && s.charAt(l)=='0') return 0;
        if(l == s.length()-1 || l == s.length()) return 1;
        else{
            int res = dfs(l+1, s);
            int tmp = Integer.parseInt(s.substring(l,l+2));
            if(tmp <= 26) res += dfs(l+2, s);
            return dy[l] = res;
        }
    }
    public int solution(String s){
        answer = 0;
        //tmp = new LinkedList<>();
        //dfs(0,s);
        dy = new int[101];
        answer = dfs(0,s);
        return answer;
    }


    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}