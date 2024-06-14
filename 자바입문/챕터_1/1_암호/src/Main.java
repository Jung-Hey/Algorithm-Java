import java.util.*;

public class Main {
    public String solution(int n, String str){
        String answer = "";
        String convert = "";
        str = str.trim();
        //풀이대로의 방법 O(n)
        for(int i=0; i<n; i++){
            convert += str.substring(0,7).replace("#","1")
                                         .replace("*","0");
            str = str.substring(7);
            answer += (char)Integer.parseInt(convert,2);
            convert = "";
        }
        //방법 1 : 복합도 O(n2)인 방법으로 지양할것.
//        for(int i=0; i<n; i++){
//            for(int j=0; j<7; j++){
//                if(str.charAt(j+(i*7)) == '#'){
//                    convert += "1";
//                }
//                else if(str.charAt(j+(i*7)) == '*'){
//                    convert += "0";
//                }
//            }
//            answer += (char)Integer.parseInt(convert,2);
//            convert="";
//        }

        return answer;

    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(Main.solution(n,str));

    }

}