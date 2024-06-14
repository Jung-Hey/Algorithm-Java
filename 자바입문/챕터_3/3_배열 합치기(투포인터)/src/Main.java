import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
//        System.arraycopy(arr1, 0, answer, 0, arr1.length);
//        System.arraycopy(arr2, 0, answer, arr1.length, arr2.length);
//        Arrays.sort(answer);
        //위와 같이 하면 안된다. 투 포인터 사용해야함
        int p1=0,p2=0;
        while (p1 < n && p2 < m){
            if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while(p1<n)answer.add(arr1[p1++]);
        while(p2<m)answer.add(arr2[p2++]);

       return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = kb.nextInt();
        }
        //
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for(int j=0; j<m; j++){
            arr2[j] = kb.nextInt();
        }
        for(int x : M.solution(n,m,arr1,arr2)) System.out.print(x+" ");


    }

}