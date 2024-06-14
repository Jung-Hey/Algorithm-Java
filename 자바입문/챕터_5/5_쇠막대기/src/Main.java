import java.util.*;
public class Main {
    public int solution(String str){
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        //()(((()())(())()))(()) ==> 17
        //막대기 문제 규칙
        //0. 스택에는 '('만 저장된다.레이저인지 닫는막대기인지 비교하기 위해 스택을 쓰는 실수를 함.. str을 charAt으로 비교해야한다..!
        //1. '(' 그냥 푸쉬
        //2. ')'가 나오면 일단 그 전거 검사
        //3. 전 인덱스 검사한게 '('면 레이저이기 때문에 pop()1회 하고 answwer+= 스택사이즈
        //4. ')'가 나오면 막대기를 닫는거임, pop()한번 하고 answer+=1
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') stk.push('(');
            else{
                //레이저임
                if(str.charAt(i-1) == '('){
                    stk.pop();
                    answer+=stk.size();
                }
                //막대기가 끝남
                else{
                    stk.pop();
                    answer+=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(M.solution(str));
    }
}


