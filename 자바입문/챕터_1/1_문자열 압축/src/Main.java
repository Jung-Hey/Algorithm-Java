import java.util.*;

public class Main {
    public String solution(String str){
        StringBuilder answer = new StringBuilder();
        str = str.toUpperCase();
        char [] tmp = str.toCharArray();
        int dis_Count = 1;

        for(int i=0; i<tmp.length; i++){
            //연속으로 들어올때
            if(i>0 && tmp[i]== tmp[i-1]){
                dis_Count++;
            }
            //연속으로 들어오다 끊길 때
            else if(i>0 && tmp[i]!= tmp[i-1]){
                if(dis_Count > 1){
                    answer.append(dis_Count);
                    dis_Count = 1;
                }
            }
            if(dis_Count == 1){answer.append((tmp[i]));}
        }
        // 이 코드를 for 반복문 다음에 추가해야 합니다.
        if(dis_Count > 1){
            answer.append(dis_Count);
        }
        return answer.toString();

    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(Main.solution(str));
        kb.close();

    }

}