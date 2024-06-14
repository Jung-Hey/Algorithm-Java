import java.util.*;

public class Main {
    public String solution(String str){
        String answer = "";

        char [] c = str.toCharArray();
        int left=0, right= c.length-1;
        while (left<right){
            if( !((c[left] >= 'A' && c[left] <= 'Z') || (c[left] >= 'a' && c[left] <= 'z')) ){
                left++;
            }
            else if( !((c[right] >= 'A' && c[right] <= 'Z') || (c[right] >= 'a' && c[right] <= 'z')) ){
                right--;
            }
            else {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            }
        }
        answer = String.valueOf(c);

     return answer;

    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(Main.solution(str));
    }

}