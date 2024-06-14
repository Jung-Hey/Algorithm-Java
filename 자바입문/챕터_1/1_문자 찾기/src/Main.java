import java.util.*;

public class Main {
    public int solution(String str, char c){
     int answer = 0;
     str = str.toUpperCase();
     c = Character.toUpperCase(c);
     //방법1
//     for(int i=0; i<str.length();i++ ){
//        if(str.charAt(i) == c){
//            answer = answer+1;
//        }
//     }
    //방법2
     for(char x : str.toCharArray()){
         if(x == c){
             answer = answer+1;
         }

     }
     return answer;

    }

    public static void main(String[] args) {
        Main Main = new Main();

        Scanner kb = new Scanner(System.in);
        System.out.print("단어 입력 : ");
        String str = kb.next();
        System.out.print("찾을 문자 입력 : ");
        char c = kb.next().charAt(0);

        System.out.println( Main.solution(str,c) );

    }

}