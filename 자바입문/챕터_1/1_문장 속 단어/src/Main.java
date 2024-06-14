import java.util.*;

public class Main {
    public String solution(String str){

     String  answer = "";
     int max = 0;
     //방법1 : split()
    //     String [] s = str.split(" ");
    //     for(String x : s){
    //         if(x.length() > max){
    //             max = x.length();
    //             answer = x;
    //         }
    //     }

     //방법2 : indexOf() , subString()
    int pos = 0;
    while( (pos= str.indexOf(' ')) != -1){
        String tmp = str.substring(0,pos);
        int len = tmp.length();
        if(len > max){
            max = len;
            answer = tmp;
        }
        str = str.substring(pos+1);
    }
    if(str.length() > max){
        answer = str;
    }
     return answer;
    }

    public static void main(String[] args) {
        Main Main = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println( Main.solution(str) );


    }

}