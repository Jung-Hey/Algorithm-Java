import java.util.*;

public class Main {
    public String solution(String str){
        String answer = "";
        //방법 1 : 직접비교
//        str = str.toUpperCase();
//        for(int i=0; i< str.length() / 2; i++){
//            if(str.charAt(i) == str.charAt(str.length()-1 - i)){
//                answer = "YES";
//            }
//            else{
//                answer = "NO";
//                break;
//            }
//        }
        // 방법 2 : reverse() , equals()
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)){
            answer = "YES";
        }
        else{
                answer = "NO";
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