import java.util.*;


class Main {
    static class point{
        int y;
        int x;
        point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sb = new StringBuilder();
        while (t-- > 0){
            int ans = 0; // 테스트케이스별 정답
            int sy = sc.nextInt();
            int sx = sc.nextInt();
            int ey = sc.nextInt();
            int ex = sc.nextInt();
            point start = new point(sy, sx);
            point end = new point(ey, ex);
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                boolean startFlag= false;
                boolean endFlag= false;
                int[] circle = new int[3];
                circle[0] = sc.nextInt();
                circle[1] = sc.nextInt();
                circle[2] = sc.nextInt();
                // 두 점의 거리
                double sd = Math.pow(start.y-circle[0], 2) + Math.pow(start.x-circle[1], 2);
                double ed = Math.pow(end.y-circle[0], 2) + Math.pow(end.x-circle[1], 2);
                double r = Math.pow(circle[2],2);
                if(sd < r){
                    ans++;
                    startFlag=true;
                }
                if(ed < r){
                    ans++;
                    endFlag=true;
                }
                if(startFlag && endFlag) {
                    ans-=2;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}