import java.util.*;
public class Main {
    public int solution(int n , int k , int [] arr ){
        int answer = -1;
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=0;
        for(int x : tset){
            cnt++;
            if(cnt==k) return x;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = kb.nextInt();
        System.out.print(M.solution(n,k,arr));
    }
}


