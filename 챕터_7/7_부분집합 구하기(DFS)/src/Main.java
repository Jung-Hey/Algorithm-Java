import java.util.*;

public class Main {
    static int n;
    static  int[] ch;

    //종이에 단계별로 그리면서 결과가 나오는것은 확인했는데 아직 완벽히 이해못함
    public void DFS(int l){
        if(l == n+1){
            String tmp="";
            for(int i=1;i<=n;i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length()>0)System.out.println(tmp);
        }
        else{
            ch[l]=1; // 사용한다
            DFS(l+1);
            ch[l]=0; // 사용하지 않는다
            DFS(l+1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int ipt = kb.nextInt();
        ch = new int[ipt+1];
        n= ipt;
        T.DFS(1);

    }
}


