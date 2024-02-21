import java.util.*;

public class Main {
    int [] ch;
    int [] dis = {1,-1,5};
    public int BFS(int s, int e){
        //첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
        //1. 메모이제이션을 통해 한번 방문한 경로를 또 방문하지 않는다.
        Queue<Integer> Q = new LinkedList<>();
        ch = new int[10001];
        int level = 0;
        //root node setting
        ch[s] = 1;
        Q.offer(s);
        //큐가 텅 빌때까지 BFS 탐색
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<dis.length; j++){
                    int nx = x+dis[j];
                    if(nx == e) return level+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            level++;

        }

        return 0;

    }

    public static void main(String[] args) {
        Main tree = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.print(tree.BFS(s,e));
    }
}


