import java.util.*;
class Point{
    int y,x;
    Point(int y,int x){
        this.y=y;
        this.x=x;
    }
}
class Main{
    static int[] cb;
    static int answer= Integer.MAX_VALUE;
    static int n,m,len;
    static ArrayList<Point> hm,pz;
    public void DFS(int l,int s){
        if(l==m){
            int sum=0;
            //1.한 집마다 조합을 통해 피자배달거리를 구하고
            //2.각 집마다 최소배달거리를 누적한 값을 answer에 min으로 최신화 시킨다.
            //3.조합 마다 1~2과정이 반복되면 결국 도시의, [최소배달거리 == 각집마다의 최소배달거리 누적값] 이 된다.
            for(Point h:hm){
                int dis = Integer.MAX_VALUE;
                for(int c:cb){
                    dis= Math.min(
                            dis,Math.abs(h.y-pz.get(c).y) + Math.abs(h.x-pz.get(c).x)
                    );
                }
                sum+=dis;
            }
            answer= Math.min( answer,sum );
        }
        else{
            //피자집의 수 C m
            for(int i=s;i<len;i++){
                cb[l]=i;
                DFS(l+1,i+1);
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        hm = new ArrayList<>();
        pz = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int tmp=kb.nextInt();
                if(tmp==1) hm.add(new Point(i,j));
                else if(tmp==2) pz.add(new Point(i,j));
            }
        }
        cb=new int[m];
        len= pz.size();
        T.DFS(0,0);
        System.out.println(answer);
    }
}