import java.util.*;
class Main {
    static int getMinIdx(int[][] dis, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<> // 사람번호 , 케빈베이컨 수
                ((a,b)-> ( a[1]==b[1] ? a[0]-b[0] : a[1]-b[1] ) ); // 정렬
        for (int i = 1; i <= n; i++) {
            int sum = Arrays.stream(dis[i],1,n+1).sum();
            pq.offer(new int[] {i,sum});
        }
        return pq.poll()[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input , setting
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dis = new int[n+1][n+1];
        for(int[] d : dis){
            Arrays.fill(d,100000);
        }
        for(int i=1; i<=n; i++) dis[i][i]=0;
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            dis[from][to] = 1;
            dis[to][from] = 1;
        }
        // solve : 플로이드 와샬
        for(int k=1; k<=n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dis[i][j] > dis[i][k] + dis[k][j] ){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        //get min
        int answer = getMinIdx(dis, n);
        System.out.println(answer);
    }
}