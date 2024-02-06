import java.util.*;
public class Main {
    public String solution(String str ){
        String answer = "YES";
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(') stk.push(c);
            else{
                if(stk.isEmpty()) return "NO";
                stk.pop();
            }
        }
        if(!stk.isEmpty())return "NO";


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
//        int n = kb.nextInt();
//        int k = kb.nextInt();
//        int [] arr = new int[n];
//        for(int i=0;i<n;i++) arr[i] = kb.nextInt();
        System.out.print(M.solution(str));
    }
}


