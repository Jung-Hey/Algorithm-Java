import java.util.*;
public class Main {
//    static int [] dy={-1,0,1,0};
//    static int [] dx={0,1,0,-1};
//    static int [] dy={-1,-1,0,1,1,1,0,-1};
//    static int [] dx={0,1,1,1,0,-1,-1,-1};
    //static ArrayList<ArrayList<Edge>> list;
    static int n,m;
    static int[] point,time,dy;
    public int solution(){
        for(int i=0;i<n;i++){
            for(int j=m;j>=time[i];j--){
                dy[j]=Math.max(dy[j],dy[j-time[i]]+point[i]);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        point=new int[n];
        time=new int[n];
        for(int i=0;i<n;i++) {
            point[i]=kb.nextInt();
            time[i]=kb.nextInt();
        }
        dy = new int[m+1];
        System.out.println(M.solution());
    }
}