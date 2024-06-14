import java.util.*;
public class Main {
    public int solution(String str, String t ){
        int answer = 0;
        int len = t.length();
        HashMap<Character,Integer> str_map = new HashMap<>();
        HashMap<Character,Integer> t_map = new HashMap<>();
        //윈도우 생성
        for(int i=0; i< len-1; i++){
            str_map.put(str.charAt(i), str_map.getOrDefault(str.charAt(i),0)+1 );
        }
        //비교할 문자열인 t 세팅
        for(int i=0; i< len; i++){
            t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i),0)+1 );
        }
        //투포인터로 슬라이딩
        int lp=0;
        for(int rp=len-1; rp<str.length();rp++){
            str_map.put(str.charAt(rp), str_map.getOrDefault(str.charAt(rp),0)+1);
            if(str_map.equals(t_map)) answer++;
            str_map.put(str.charAt(lp),str_map.get(str.charAt(lp))-1);
            if(str_map.get(str.charAt(lp)) == 0) str_map.remove(str.charAt(lp));
            lp++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        String t = kb.next();
        System.out.print(M.solution(str,t));
    }
}


