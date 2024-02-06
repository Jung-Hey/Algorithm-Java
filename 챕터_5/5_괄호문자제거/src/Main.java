import java.util.*;
public class Main {
    public String solution(String str ){
        String answer = "";
        Stack<Character> stk = new Stack<>();
        //꼼수정답
        int tmp=0;
//        for(char c : str.toCharArray()){
//            if(c == '('){
//                tmp++;
//                continue;
//            }
//            if(c == ')'){
//                tmp--;
//                continue;
//            }
//            if(tmp==0)answer+= c;
//
//        }
        // 정답에 가깝게 풀기
        for(char c : str.toCharArray()){
           if(c == ')'){
               stk.push(c);
               while (stk.pop() != '(');
           }
           else{
               stk.push(c);
           }
        }
        for(int i=0; i<stk.size();i++){
            answer+= stk.get(i);
        }


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


