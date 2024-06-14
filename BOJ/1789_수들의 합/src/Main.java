import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        int answer=0;
        long tmp = 0L;
        for(int i=1; ; i++){
            tmp+=i;
            answer++;
            if(tmp == s) break;
            else if(tmp > s){
                answer--;
                break;
            }
        }
        System.out.println(answer);
    }
}