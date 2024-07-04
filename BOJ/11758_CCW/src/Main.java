import java.util.*;

class Main {
    static class point{
        int x;
        int y;
        point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    //신발끈 알고리즘
    public static int CCW(point[] p){
        int res = ( (p[0].x * p[1].y) + (p[1].x * p[2].y) + (p[2].x * p[0].y) )
                - ( (p[0].y * p[1].x) + (p[1].y * p[2].x) + (p[2].y * p[0].x) );
        if(res > 0) res= 1;
        else if(res < 0 ) res=-1;
        else res=0;

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        point[] p = new point[3];
        for(int i=0; i<3; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            p[i]= new point(x,y);
        }
        int answer = CCW(p);
        System.out.println(answer);


    }
}
