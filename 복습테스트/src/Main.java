import java.util.*;
public class Main {
    int [] ch;
    int [] dis = {-1,1,5};

    public int BFS(int s,int e){
        int level = 0;
        Queue<Integer> Q = new LinkedList<>();
        ch = new int[10001]; // 직선좌표의 점은 1~10000이기 때문에 배열 크기 초기화
        //s는 현수의 위치이다. 현수의 위치에서부터 시작되는 루트노트이기 때문에 방문했다는 의미로 1로 초기화
        ch[s] = 1;
        Q.offer(s);
        //큐가 빌 때까지 반복
        while (!Q.isEmpty()){
            //for(int p : Q)System.out.print(p+" ");
            //System.out.println();
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<dis.length; j++){
                    int nx = x + dis[j];
                    if(nx == e)return level+1;
                    if(nx>=0 && ch[nx]==0 ){
                        Q.offer(nx);
                        ch[nx]=1;
                    }
                 }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.print(M.BFS(s,e));

    }
}



