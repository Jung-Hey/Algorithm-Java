import java.util.*;
public class Main {
    public String solution( String str1,String str2){
        String answer="YES";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);

        }
        for(char x : str2.toCharArray()){
            if( !map.containsKey(x) || map.get(x)==0 ) {
                return "NO";
            }
            else map.put(x, map.get(x)-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(M.solution(str1,str2));
    }
}


