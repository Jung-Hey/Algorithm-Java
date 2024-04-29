import java.util.*;

public class Main {
    static int n,limit;
    static int answer=Integer.MIN_VALUE;
    static int[] point,time,dy;

    public int solution(){
        //냅색특징 동전교환 문제처럼 동전을 무한으로 쓸 수 있으면 정방향
        //지금처럼 1문제만 풀 수 있다 (유한하다) j가 뒤에서 돌아야 함.
        for(int i=0;i<n;i++){
            for(int j=limit; j>=time[i]; j--){
                dy[j]=Math.max(dy[j],dy[j-time[i]] + point[i]);
            }
            System.out.println(Arrays.toString(dy));
        }
        return dy[limit];

    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        limit=kb.nextInt();//제한시간
        dy=new int[limit+1];
        point=new int[n];
        time=new int[n];
        for(int i=0;i<n;i++){
            int p = kb.nextInt();
            int t = kb.nextInt();
            point[i]= p;
            time[i]= t;
        }
        System.out.println(M.solution());

    }
}