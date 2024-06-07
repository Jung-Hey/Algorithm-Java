import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int P = sc.nextInt();
        int[] dy = new int[D+1];
        for(int i=0;i<P;i++){
            int L = sc.nextInt(); // 파이프 길이
            int C = sc.nextInt(); // 파이프 용량
            for(int j=D; j>L; j--){
                if(dy[j-L] == 0) continue;
                dy[j] = Math.max(dy[j] , Math.min(C,dy[j-L]));
            }
            dy[L] = Math.max(dy[L],C);
        }
        //System.out.println(Arrays.toString(dy));
        System.out.println(dy[D]);

    }
}

