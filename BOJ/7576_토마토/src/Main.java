import java.util.*;
class Main {
    static int n,m;
    static int[][] arr;
    static int target,total;
    static Queue<int[]> q;
    static int bfs(){
        int L=0;
        boolean flag = true;
        int [] dy  = {-1,0,1,0};
        int [] dx  = {0,1,0,-1};
        // 시작하기 전부터 모든 토마토가 익으면
        if(target==total) return 0;
        // bfs
        while (!q.isEmpty() && flag ){
            int len = q.size();
            L++;
            for(int i=0; i<len; i++){
                int[] x  = q.poll();
                for(int j=0; j<4; j++){
                    int ny = x[0] + dy[j];
                    int nx = x[1] + dx[j];
                    if(ny>=0 && ny<m && nx>=0 && nx<n && arr[ny][nx]==0){
                        arr[ny][nx]=1; // 익은거로 바꿈
                        q.offer(new int[]{ny,nx});
                        target++;
                        if(target==total){
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }
        // 모든 토마토가 익을 수 없는경우
        if(target!=total) L = -1;
        return L;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        total = n*m;
        target=0;
        q = new LinkedList<>();
        arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int t = sc.nextInt();
                arr[i][j] = t;
                if(t == 1) {
                    target++;
                    q.offer(new int[]{i,j});
                }
                else if(t == -1){
                    total--;
                }
            }
        }
        System.out.println(bfs());



    }
}