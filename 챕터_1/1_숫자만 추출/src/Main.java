import java.util.*;

public class Main {
    public int solution(String str){

        // 꼼수
//        String tmp = str.replaceAll("[^0-9]","");
//        answer = Integer.parseInt(tmp);

        //정상적인 풀이
        int answer = 0;
        for(char c :  str.toCharArray()){
            if(c >= 48 && c <= 57){
                answer = ( answer * 10 ) + (c-48);
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