import java.util.*;
public class Main {
    public int solution(String str){
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        //352+*9- ==> 12
        for(char c : str.toCharArray()){
            if(Character.isDigit(c))stk.push(c-48); //숫자 아스키코드가 48번 부터 시작이기 때문
            else{
                int rp=stk.pop();
                int lp=stk.pop();
                if(c == '+') stk.push(lp+rp);
                else if(c == '-')stk.push(lp-rp);
                else if(c == '*')stk.push(lp*rp);
                else if(c == '/')stk.push(lp/rp);
            }
        }
        answer = stk.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(M.solution(str));
    }
}


