import java.util.*;
class Main {
    public static String solve(long[] land,int t){
        Arrays.sort(land);
        int max=1; // 빈도
        long maxNum=0; // 값
        //정복했는지 체크
        int cnt=1;
        for(int k=1; k<t; k++){
            if(land[k-1]==land[k]){
                cnt++;
                if(cnt > max){
                    max = cnt;
                    maxNum = land[k];
                }
            }
            else cnt=1;
        }
        //out
        if(t/2 < max) return String.valueOf(maxNum);
        else return "SYJKGW";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //n번 반복
        for(int i=0; i<n; i++){
            int t = sc.nextInt(); //병사 수
            long[] land = new long[t];
            //t (땅) 만큼 반복
            for(int j=0; j<t; j++){
                land[j] = sc.nextLong();
            }
            System.out.println(solve(land,t));
        }
    }
}