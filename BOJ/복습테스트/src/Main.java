import java.util.*;

class Main {
    static int[] arr;
    static int N,M;

    static boolean isPossible(int mid){
        int prev = 0;
        for(int i=0; i< arr.length; i++){
            if(arr[i]-mid <= prev){
                prev = arr[i]+mid;
            }
            else{
                return false;
            }
        }
        return (N-prev) <= 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        N =sc.nextInt(); //굴다리의 길이
        M =sc.nextInt(); //설치할 가로수 갯수.
        arr = new int[M];// 가로등이 설치된 지점 입력 받기
        for(int i = 0; i < M; i++) arr[i] = sc.nextInt();
        int left = 1;
        int right = N;
        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        //output
        System.out.println(result);

    }
}