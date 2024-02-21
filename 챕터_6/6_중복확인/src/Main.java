import java.util.*;
public class Main {
    public char solution(int n, int[] arr){
        // 중복이면 D 아니면 U

        // O(n)시간복잡도로 풂
        char answer = 'U';
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i,0)+1);
            if(map.get(i)>1) return 'D';
        }

        //O(n log n)이지만 정렬로 풂
//        Arrays.sort(arr);
//        for(int i=0;i<n-1;i++){
//            if(arr[i]==arr[i+1]) return 'D';
//        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        System.out.print(M.solution(n,arr));


    }
}


