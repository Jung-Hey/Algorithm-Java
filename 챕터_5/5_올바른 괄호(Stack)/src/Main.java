import java.util.*;
public class Main {
    public String solution(String str){
        String answer = "YES";
        //여는 괄호면 push , 닫는 괄호면 pop() 시키면 되는 간단한 문제로
        // empty()가 아니면 pop() 시키면 되고 최종적으로 empty()가 아니면 "NO" return하면 되는 간단한 문제
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(') stk.push(c);
            else{
                if(stk.empty()) return "NO";
                else stk.pop();
            }
        }
        if(!stk.empty()) return "NO";


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(M.solution(str));


    }
}


