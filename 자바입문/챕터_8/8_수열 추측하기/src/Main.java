import java.util.*;
class Main{
    static int[] b, p, ch;
    static int n, f;
    boolean flag=false;
     static int[][] dy=new int[35][35];
    public int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        // 조합의 경우수에 있는 식
        else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L==n){
            if(sum==f){
                for(int x : p) System.out.print(x+" ");
                flag=true;
            }
        }
        else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i; // 순열 p
                    DFS(L+1, sum+(p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        f=kb.nextInt();
        b=new int[n];
        p=new int[n];
        ch=new int[n+1];
        for(int i=0; i<n; i++) b[i]=T.combi(n-1, i);
        //combi는 조합식을 짜주는 함수로
        // n이 4일 경우 1 3 3 1 이 나오는데 이는
        // 어떤 순열이 올지는 모르지만 순열의 0번째는 1번, 1번째는 3번 ...
        // 이런 의미에 조합식이 나오고 순열을 계속 생성한다.
        // f=16이고 3 1 2 4 라는 순열이 나왔을때 1 3 3 1 조합식을 곱하면
        // 3*1, 1*3, 2*3, 4*1 = 16 으로 정답이 된다.
        T.DFS(0, 0);
    }
}