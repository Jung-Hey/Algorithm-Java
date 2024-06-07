import java.util.*;

class Solution {
    static LinkedList<String> tmp ;
    static ArrayList<String> answer;
    public void dfs(int l, String s) {
        if(l==s.length() && tmp.size() == 4){
            String ip="";
            for(String str : tmp) ip+=str+".";
            ip=ip.substring(0,ip.length()-1);
            answer.add(ip);
            //System.out.println(ip);
        }
        else{
            for(int i=l; i<s.length(); i++){
                if(s.charAt(i)=='0' && i > l)return;
                String num = s.substring(l, i+1);
                if(Integer.parseInt(num) > 255) return;
                tmp.offer(num);
                dfs(i+1,s);
                tmp.pollLast();
            }
        }


    }
    public String[] solution(String s){
        answer = new ArrayList<>();
        tmp = new LinkedList<>();
        dfs(0,s);

        return answer.stream().toArray(String[] :: new);
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