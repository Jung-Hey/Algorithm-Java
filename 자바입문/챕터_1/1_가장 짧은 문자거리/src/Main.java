import java.util.*;

public class Main {
    public int[] solution(String str, char target){
        int[] answer = new int[str.length()];
        char[] tmp = str.toCharArray();

        int p = 1000;
        int[] left_compare = new int[str.length()];
        int[] right_compare = new int[str.length()];

        for(int i = 0; i< left_compare.length; i++)
        {
            if(tmp[i] == target ){ p=0;}
            else{p+=1;}
            left_compare[i] = p;
        }
        p=1000;
        for(int i = right_compare.length-1; i>=0; i--)
        {
            if(tmp[i] == target ){ p=0;}
            else{p+=1;}
            right_compare[i] = p;
        }
        for(int i = 0; i< answer.length; i++){
            int short_p = Math.min(left_compare[i], right_compare[i]);
            answer[i] = short_p;
            System.out.print(answer[i]+" ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char target = kb.next().charAt(0);
        Main.solution(str, target);
        //System.out.println();

    }

}