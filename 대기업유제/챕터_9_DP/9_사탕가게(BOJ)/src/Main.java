import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            String sm = sc.next();
            int m = Integer.parseInt(sm.replace(".",""));
            if(n==0 && m==0) break;
            int[] dy = new int[m+1];
            // dp
            for(int i=0; i<n; i++){
                int c = sc.nextInt();
                String sp = sc.next();
                int p = Integer.parseInt(sp.replace(".",""));
                for(int j=p; j<=m; j++){
                    dy[j]=Math.max(dy[j], dy[j-p]+c);
                }
            }
            System.out.println(dy[m]);
        }

    }
}

