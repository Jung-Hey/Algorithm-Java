import java.util.*;

public class Main {
    public String solution(String str){
        String answer = "";
        for(int i=0; i< str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i){
                answer += str.charAt(i);
            }
        }
     return answer;
    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(Main.solution(str));
    }

}