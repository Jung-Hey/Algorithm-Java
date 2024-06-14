import java.util.*;

public class Main {
    public ArrayList<String> solution(int n,String[] str){

     ArrayList<String>  answer = new ArrayList<>();

     //방법1 : reverse() 사용
    //     for(String s : str){
    //        String tmp = new StringBuilder(s).reverse().toString();
    //         answer.add(tmp);
    //     }
     //방법2 : reverse() 사용 x, 투포인터로 직접 구현
     for(String s : str){
         char [] c = s.toCharArray();
         int left=0, right = s.length()-1;
         while(left < right){
             char tmp = c[left];
             c[left] = c[right];
             c[right] = tmp;
             left++;
             right--;
         }
         String tmp = String.valueOf(c);
         answer.add(tmp);
     }
     return answer;

    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String [] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = kb.next();
        }
        for(String x : Main.solution(n,str) ){
            System.out.println(x);
        }

    }

}