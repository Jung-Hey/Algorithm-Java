import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int len = arr.length;
        for(int i=0; i<len;i++){
            int tmp=1;
            for(int j=0; j<len; j++){
                if(arr[i] < arr[j]){
                    tmp++;
                }
            }
            answer.add(tmp);

        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();
        for(int j : M.solution(n,arr)) System.out.print(j+" ");


    }

}