import java.util.*;
class Solution {
    public String solution(String s){
        String answer = new String();
        Stack<String> stk = new Stack<>();
        for(Character x : s.toCharArray()){
            if(x==')'){
                String tmp="";
                while (!stk.isEmpty()){
                    String c = stk.pop();
                    if(c.equals("(")){
                        String num = "";
                        while (!stk.isEmpty() && Character.isDigit(stk.peek().charAt(0))){
                            num = stk.pop()+num;
                        }
                        String res="";
                        int cnt=0;
                        if(num.equals("")) cnt=1;
                        else cnt = Integer.parseInt(num);
                        for(int i=0;i<cnt;i++) res+=tmp;
                        stk.push(res);
                        break;
                    }
                    tmp = c+tmp;
                }
            }
            else stk.push(String.valueOf(x));
        }
        for(String x : stk) {
            answer+=x;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
//        System.out.println(T.solution("2(ab)k3(bc)"));
//        System.out.println(T.solution("2(ab3((cd)))"));
//        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
//        System.out.println(T.solution("3(ab2(sg))"));
    }
}