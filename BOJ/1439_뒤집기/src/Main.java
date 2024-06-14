import java.util.*;
class Main {
    static String s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int len = s.length();
        int zeroCnt=0;
        int oneCnt=0;
        //시작값
        if(s.charAt(0)=='0') zeroCnt++;
        else oneCnt++;
        for(int i=1; i<len; i++){
            if(s.charAt(i-1) != s.charAt(i)){
                if(s.charAt(i)=='1')oneCnt++;
                else zeroCnt++;
            }
        }
        int res = Math.min(oneCnt, zeroCnt);
        System.out.println(res);
    }
}