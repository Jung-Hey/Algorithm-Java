import java.util.*;
public class Main {
    static int[][] dy= new int [35][35];
    public int DFS(int n,int r){
        //1. n C r : n개 중에서 r개를 뽑을때의 경우의 수
        //2. n C r == n-1 C r-1 + n-1 C r이다
        //3. r(뽑을게 0)이면 1을 리턴
        //4. n==r이면 경우의 수가 무조건 1이므로 1을 리턴
        if(n==r || r==0) return 1;
        else if(dy[n][r]!=0) return dy[n][r];
        else return dy[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        //arr= new int[n+1];
        //for(int i=1;i<=n;i++)arr[i]=i;
        int r= kb.nextInt();
        System.out.print(T.DFS(n,r));




    }
}


