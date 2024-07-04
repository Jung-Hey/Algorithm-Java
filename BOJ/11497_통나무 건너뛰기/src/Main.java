import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // t : 테스트케이스 만큼 반복
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int len = n;
            int [] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = sc.nextInt();
            }
            Deque<Integer> dq = new LinkedList<>();
            //정렬
            Arrays.sort(arr);
            //통나무가 홀수개인 경우
            if(len%2==1){
                len--;
                dq.add(arr[n-1]);
            }
            // 최소 난이도가 되도록 배치
            for(int j=len-1; j>=0; j-=2){
                int a = arr[j-1];
                int b = arr[j];
                dq.addFirst(a);
                dq.addLast(b);
            }
            //get answer
            int answer = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) arr[j] = dq.pollFirst();
            answer= Math.abs(arr[0]-arr[n-1]);
            for(int j=0; j<n-1; j++){
                answer= Math.max(answer,Math.abs(arr[j]-arr[j+1]));
            }
            sb.append(answer).append("\n");
        }
        //output
        System.out.println(sb);
    }
}
