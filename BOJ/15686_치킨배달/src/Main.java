import javax.xml.stream.events.StartDocument;
import java.util.*;
class Main {
    static int[][]arr;
    static int n,m,answer;
    static int[] pm;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> home;
    public static void getMinDistance(int[] pm){
        int total=0;
        for(int[] pos : home){
            int tmp = 1000; // 한 집 마다 최소거리
            for(int p : pm ){ // 치킨 집 중에 최소거리
                int[] ck = chicken.get(p);
                int dis = Math.abs(pos[0]-ck[0]) + Math.abs(pos[1]-ck[1]);
                tmp = Math.min(tmp,dis);
            }
            total+=tmp; // 집마다 최소거리 더함
        }
        // 조합마다 최소면 갱신
        answer=Math.min(answer,total);

    }
    public static void dfs(int l , int start){
        if(l==m){
            //System.out.println(Arrays.toString(pm));
            getMinDistance(pm); // 최소 거리 구하기
        }
        else{
            for(int i=start; i< chicken.size(); i++){
                pm[l] = i;
                dfs(l+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = Integer.MAX_VALUE;
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int p =sc.nextInt();
                arr[i][j] = p;
                if(p==2) chicken.add(new int[]{i,j}); // 치킨집 저장
                else if(p==1) home.add(new int[]{i,j}); // 집 저장
            }
        }
        pm = new int[m];
        dfs(0,0);
        // output
        System.out.println(answer);
    }
}