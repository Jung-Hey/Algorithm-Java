// 일반적인 방식
//import java.util.*;
//public class Main {
//    // 1.마구간 정하기의 핵심은 : mid(최소거리)가 있을때 몇마리의 말을 배치할 수 있느냐를 count에서 구함.
//    // 선언한것 이상으로 구해지면 mid를 늘려서 계속 이진탐색.
//    // 2.뮤직비디오 문제의 핵심은 : mid(비디오 길이)가 있을때 비디오를 몇개 만들 수 있는지 count에서 구함.
//    // 최소비디오이기 때문에 2개 만들어지면 m이 3일때 mid(비디오 길이)를 늘려볼 수 있음.
//    public int count(int[]arr, int distance){
//        int ep=0, cnt=1;
//        for(int i=1; i<arr.length; i++){
//            //배치가능
//            if(arr[i]-arr[ep] >= distance){
//                cnt++;
//                ep=i;
//            }
//        }
//        return  cnt;
//    }
//    public int solution(int n ,int m, int[] arr){
//        // 이번문제에서는 배치가능한 말의 수 vs  m(말의 수)
//        int answer = 0;
//        Arrays.sort(arr);
//        //최소 거리 그냥 1로 잡음
//        int lt = 1;
//        int rt = arr[arr.length-1]-arr[0]; //arr[arr.length-1]로 끝내도 큰 차이 없음
//        while (lt<=rt){
//            int mid = (lt+rt) / 2;
//            //mid최소거리만큼 배치했을때 m보다 더 배치할 수 있으므로 거리를 늘린다.
//            if(count(arr,mid) >= m){ // mid : 말들의 최소거리
//                lt = mid+1;
//                answer = mid;
//            }
//            else rt = mid-1;
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main M = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int m = kb.nextInt();
//        int [] arr = new int [n];
//        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
//        System.out.print(M.solution(n,m,arr));
//    }
//}

////////////////////////////////////////////////////////////////////////

//내가 조금 수정해서 푼 방식
import java.util.*;
public class Main {
    public int[] count(int[]arr, int distance){
        int [] res = new int[2];
        int ep=0, cnt=1;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            //배치가능
            if(arr[i]-arr[ep] >= distance){
                cnt++;
                min = Math.min(min,arr[i]-arr[ep]); // 말들의 최소거리
                ep=i;
            }
        }
        res[0] = cnt; // distance로 배치되는 말의 수
        res[1] = min; // 말들의 최소 거리
        return  res;
    }
    public int solution(int n ,int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1]-arr[0]; //arr[arr.length-1]로 끝내도 큰 차이 없음
        while (lt<=rt){
            int mid = (lt+rt) / 2;
            int res[] = count(arr,mid);
            //mid최소거리만큼 배치했을때 m보다 더 배치할 수 있으므로 거리를 늘린다.
            if(res[0] >= m){ // mid : 말들의 최소거리
                lt = mid+1;
                answer = res[1]; // answer = mid 가 아닌 count메소드에서 계산한 말들의 최소거리를 넣어준다.
                //(말들이 여러마리일때 가장 가까운말의 최대거리를 구하라고 문제에 명시되어있어서)
            }
            else rt = mid-1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        System.out.print(M.solution(n,m,arr));
    }
}

