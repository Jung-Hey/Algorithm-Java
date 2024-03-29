import java.util.*;

public class Main {
    static int n;
    static int[] dy;

    public void solution(){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n+1;i++) dy[i]=dy[i-1]+dy[i-2];
        System.out.println(dy[n+1]);

    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        dy=new int[n+2];
        M.solution();


    }
}


