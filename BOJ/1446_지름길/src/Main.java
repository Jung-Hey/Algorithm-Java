import java.util.*;
class Road implements Comparable<Road>{
    int s;
    int e;
    int cost;
    Road(int s, int e, int cost){
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Road r){
        if(r.s==this.s) return this.e - r.e;
        else return this.s - r.s;
    }
}
class Main {
    static int n,d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 지름길 개수
        d = sc.nextInt(); // 고속도로 길이
        ArrayList<Road> path = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            if (e > d) //종료지점이 고속도로 거리를 넘어가서는 안된다
                continue;
            if (e - s > cost)// 지름길이 최단거리일 경우에만 add
                path.add(new Road(s, e, cost));
        }
        Collections.sort(path);
        int[]dis = new int[d+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        int move = 0;
        int idx = 0;
        while (move < d){
            // 지름길이 있으면
            if (idx < path.size()){
                Road tmp = path.get(idx);
                // 목적지와 move가 같을떄 최소거리 갱신 , 비교끝냈으니 idx 증가
                if(move == tmp.s){
                    dis[tmp.e] = Math.min(dis[tmp.s]+tmp.cost , dis[tmp.e] );
                    idx++;
                }
                // 지름길 없으면 일반적으로 가는 거리
                else {
                    dis[move + 1] = Math.min(dis[move + 1], dis[move] + 1);
                    move++;
                }
            }
            // 지름길 없으면 일반적으로 가는 거리
            else {
                dis[move + 1] = Math.min(dis[move + 1], dis[move] + 1);
                move++;
            }
        }
        //output
        //for(int i=1; i<=d; i++)System.out.println(i+" "+dis[i]);
        System.out.println(dis[d]);




    }
}