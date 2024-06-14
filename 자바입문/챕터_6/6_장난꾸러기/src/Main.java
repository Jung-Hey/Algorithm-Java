import java.util.*;
public class Main {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        //원본 arr와 깊은 복사한 배열을 만들어 인덱스 순서대로 비교해서 풀 수 있다.
        int [] tmp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(tmp);
        for(int i=0; i<n; i++) if(arr[i] != tmp[i]) answer.add(i+1);

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        for(int i : M.solution(n,arr)) System.out.print(i+" ");
    }
}


