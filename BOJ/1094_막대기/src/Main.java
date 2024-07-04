import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] stick = {64,32,16,8,4,2,1};
        int answer=0;
        int tmp=0;
        for(int i=0; i<stick.length; i++){
            if(tmp+stick[i] <= x){
                tmp+=stick[i];
                answer++;
                if(tmp==x)break;
            }
        }
        System.out.println(answer);
    }
}