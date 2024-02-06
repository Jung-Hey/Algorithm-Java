import java.util.*;

public class Main {
    public String solution(String str){

     String  answer = "";
     for (char x : str.toCharArray()){
         if(Character.isUpperCase(x)){
             answer +=  Character.toLowerCase(x);
         }
         else{
             answer += Character.toUpperCase(x);
         }
     }

     return answer;

    }

    public static void main(String[] args) {
        Main Main = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println( Main.solution(str) );

    }

}