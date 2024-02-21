import java.util.*;
public class Main {
    public String solution(String str ){
        String answer = "";
        // )면 여는괄호( 가 나올때까지 pop()한다. 그럼 최종적으로 괄호안에 있는 문자는 제거됨
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()){
            if(c != ')') stk.push(c);
            else{
                while(!stk.empty() && stk.pop()!='(');
            }
        }
        for(char c : stk)answer+=c;


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(M.solution(str));
    }
}


