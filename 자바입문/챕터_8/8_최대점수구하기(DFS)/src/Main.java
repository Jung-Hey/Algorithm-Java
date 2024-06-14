import java.util.*;
public class Main {
    static  int[] score;
    static  int[] time;
    static int limit=0;
    static int n;
    static int answer=0;
    public void DFS(int v,int s, int t){
        //System.out.println("v: "+v+" 점수: "+s+" 시간: "+t);
        if(t > limit) return;
        else if(v==n) answer = Math.max(answer,s);
        else{
            DFS(v+1,s+score[v], t+time[v]);
            DFS(v+1,s, t);
        }

    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int ipt = kb.nextInt();
        n = ipt;
        score =new int[n];
        time =new int[n];
        int ipt_limit = kb.nextInt();
        limit=ipt_limit;
        for(int i=0;i<n;i++) {
            score[i] = kb.nextInt();
            time[i] = kb.nextInt();
        }
        T.DFS(0,0,0);
        System.out.println(answer);

    }
}


