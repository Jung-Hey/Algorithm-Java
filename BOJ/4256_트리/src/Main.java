import java.util.*;
class Main {
    static int[] pre;
    static int[] in;
    static StringBuilder sb;
    static void getPost(int s, int e, int root) {
        for(int i=s; i<e; i++) {
            // 루트 노드 찾으면
            if(in[i] == pre[root]) {
                //루트를 기준으로 왼쪽
                getPost(s, i, root+1);
                //루트를 기준으로 오른쪽
                getPost(i+1, e, root+i-s+1);
                sb.append(pre[root] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb= new StringBuilder();
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            pre = new int[n+1];
            in = new int[n+1];
            for(int i=0; i<n; i++) pre[i]= sc.nextInt();
            for(int i=0; i<n; i++) in[i]= sc.nextInt();
            getPost(0,n,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}