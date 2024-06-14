import java.util.*;
class brick implements Comparable<brick>{
    int s,h,w;
    brick(int s,int h,int w){
        this.s=s;
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(brick b){
        return b.s - this.s;
    }
}

public class Main {
    static int n;
    static int[] dy;
    static brick [] arr;

    public void solution(){
        int answer=0;
        Arrays.sort(arr);
        answer=dy[0]=arr[0].h;
        for(int i=1; i<n; i++){
            int max=0;
            for(int j=i-1; j>=0; j--) if(arr[i].w < arr[j].w) max = Math.max(max,dy[j]);
            dy[i]=max+arr[i].h;
            answer= Math.max(answer,dy[i]);
        }
        //for(int i=0; i<n; i++) answer= Math.max(answer,dy[i]);
        System.out.println(answer);
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr=new brick[n];
        dy=new int[n];
        for(int i=0;i<n;i++) {
            int a= kb.nextInt();
            int b= kb.nextInt();
            int c= kb.nextInt();
            arr[i]=new brick(a,b,c);
        }
        M.solution();
    }
}


