//import java.util.*;
//public class Main {
//    static int [] unf;
//    static int find(int e){
//        if(unf[e] == e) return e;
//        else return unf[e] = find(unf[e]);
//    }
//    static void union(int a, int b){
//        int fa = find(unf[a]);
//        int fb = find(unf[b]);
//        if(fa != fb) unf[fa] = fb;
//    }
//    public static void main(String[] args) {
//        Main M = new Main();
//        Scanner sc = new Scanner(System.in);
//        int ans=0;
//        int n= sc.nextInt();
//        int m= sc.nextInt();
//        unf = new int[n+1];
//        for(int i=1;i<=n;i++) unf[i]=i;
//        for(int i=0; i<m;i++){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            union(a,b);
//        }
//        System.out.println(Arrays.toString(unf));
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=1;i<=n;i++){
//            set.add(find(unf[i]));
//            System.out.println(find(unf[i])+" ");
//        }
//        ans = set.size();
//
//    }
//}
//

import java.util.*;
class Main {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb){
            unf[fa]=fb;
            System.out.println(Arrays.toString(unf));
        }
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int m=kb.nextInt();
//        unf=new int[n+1];
//        for(int i=1; i<=n; i++) unf[i]=i;
//        for(int i=1; i<=m; i++){
//            int a=kb.nextInt();
//            int b=kb.nextInt();
//            Union(a, b);
//        }
//        System.out.println(Arrays.toString(unf));
//        for(int i=1;i<=n;i++){
//            System.out.println(Find(i)+" ");
//        }
        PriorityQueue<Integer> maxq = new PriorityQueue<>( (a,b)->(b-a) );
        maxq.offer(2);
        maxq.offer(10);
        maxq.offer(4);
        int v = maxq.poll();
        maxq.offer(v+1);
        System.out.println(maxq.poll());
    }
}