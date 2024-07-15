import java.util.*;
class Solution {

    static LinkedList<String> tmp;
    static List<String> list;

    void dfs(int start, String s){
        if(tmp.size()==4 && start == s.length()){
            String res="";
            for (String x : tmp) {
                res+=x+".";
            }
            res = res.substring(0,s.length()-1);
            list.add(res);
        }
        else{
            for(int i=start; i<s.length(); i++){
                if(s.charAt(start)=='0' && i > start  ) return;
                String x = s.substring(start, i+1);
                if(Integer.parseInt(x) > 255) return;
                tmp.add(x);
                dfs(i+1,s);
                tmp.pollLast();
            }
        }
    }
    public String[] solution(String s){
        //String[] answer = {};
        tmp = new LinkedList<>();
        list = new ArrayList<>();
        dfs(0,s);

        return list.stream().toArray(String[] :: new );
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}