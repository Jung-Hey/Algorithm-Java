import java.util.*;
public class Main {
    public String solution(String a, String b){
        String answer = "YES";
        //큐 안쓰고 처리
//        int cnt=0;
//        String tmp = "";
//        for(char c : b.toCharArray()){
//            if(c == a.charAt(cnt)){
//                if(tmp.length() == a.length()) break;
//                if(cnt != a.length()-1)cnt++;
//                tmp += c;
//            }
//        }
//        if(!tmp.equals(a)) answer = "NO";

        //풀이
        Queue<Character> que = new LinkedList<>();
        for(char c : a.toCharArray()) que.offer(c);
        for(char c : b.toCharArray()){
            if(que.contains(c)){
                if(c != que.peek()) return "NO";
                else que.poll();
            }
        }
        if(!que.isEmpty()) answer ="NO";

        return answer;

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.print(M.solution(a,b));
    }
}


