import java.util.*;

class Main {
    static class Connect implements Comparable<Connect>{
        int v1;
        int v2;
        int cost;
        public Connect(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Connect o) {
            return this.cost - o.cost;
        }
    }
    static int[] unf;
    static int ans;
    public static int find(int e){
        if(e == unf[e]) return e;
        else return unf[e]=find(unf[e]);
    }
    public static void union(int a, int b){
//        int fa = find(a);
//        int fb = find(b);
        if(a != b){
            unf[a]=b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ans=0;
        int n =sc.nextInt();
        unf = new int[n+1];
        for(int i=1;i<=n; i++) unf[i] = i;
        ArrayList<Connect> list = new ArrayList<>();
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a!=b) list.add(new Connect(a,b,c));
        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            Connect tmp = list.get(i);
            int fa = find(tmp.v1);
            int fb = find(tmp.v2);
            if(fa != fb){
                ans+=tmp.cost;
                union(fa,fb);
                //System.out.println(fa+" - "+ fb+  " 연결 , ans = "+ans);
            }
        }
        System.out.println(ans);
    }
}