import java.util.*;
public class Main {
    public int solution(int n ,int k, int[] arr){
        int answer= -1;
        //10 3
        //13 15 34 23 45 65 33 11 26 42
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=1;
        for(int i : set){
            if(cnt==k)return i;
            cnt++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        System.out.print(M.solution(n,k,arr));

    }
}


