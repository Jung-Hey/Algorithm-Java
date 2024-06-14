import java.util.*;
public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1=0, p2=0;
        while(p1<n&&p2<m){
            if(arr1[p1]==arr2[p2]){
                answer.add(arr1[p1++]);
                p2++;
            }
            else if(arr1[p1]<arr2[p2]){
                p1++;
            }
            else{
                p2++;
            }

        }


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
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for(int j=0; j<m; j++){
            arr2[j] = kb.nextInt();
        }
         for(int x : M.solution(n,m,arr1,arr2)) System.out.print(x+" ");
    }

}