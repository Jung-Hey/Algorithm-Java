import java.util.*;
public class Main {
    static int n,m;
    static int[] unf;
    public int find(int v){
        if(v==unf[v]) return v;
        // *중요: return find(unf[v]); 정답 출력되지만 아래와 같이 써야 경로 압축됨.
        else return  unf[v]=find(unf[v]);
    }
    public void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        unf=new int[n+1];
        for(int i=1;i<=n;i++) unf[i]=i; //각 배열 초기화
        for(int i=1;i<=m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            M.union(a,b);
        }
        int target_A = kb.nextInt();
        int target_b = kb.nextInt();
        if(M.find(target_A)==M.find(target_b)) System.out.println("YES");
        else System.out.println("NO");


    }
}


