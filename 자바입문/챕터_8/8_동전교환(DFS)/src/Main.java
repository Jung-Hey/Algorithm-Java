import java.util.*;
public class Main {
    static int n;
    static Integer[] coins;
    static  int change;
    static int answer=Integer.MAX_VALUE;
    public void DFS(int l,int sum){
        // l은 동전의 개수, sum은 동전금액의 합으로 생각하고 문제를 해결한다.
        if(sum>change) return;
        // 찾은 동전개수보다 더 큰 동전개수는 탐색할 필요없음
        if(l>=answer) return;
        //System.out.println("l : "+l+" sum: "+sum+" answer : "+answer);
        if(sum==change) answer= Math.min(answer,l);
        else{
            for(int i=0;i<n;i++){
                DFS(l+1,sum+coins[i]);
            }
        }


    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        coins=new Integer[n];
        for(int i=0;i<n;i++) coins[i] = kb.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());
        change=kb.nextInt();
        T.DFS(0,0);
        System.out.println(answer);
    }
}


