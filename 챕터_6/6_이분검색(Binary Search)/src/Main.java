import java.util.*;
public class Main {
    public int solution(int n ,int target, int[] arr){
        int answer = -1;
        //이진탐색은 오름차순 정렬되었을때 할 수 있으므로 정렬시킴
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            if(arr[mid] == target) return mid+1;
            //중앙값이 타겟보다 작으면, 중앙값기준 왼쪽 탐색
            else if (arr[mid] < target) start = mid+1;
            //중앙값이 타겟보다 크면, 중앙값기준 오른쪽 탐색
            else end = mid-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int target = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        System.out.print(M.solution(n,target,arr));


    }
}


