import java.util.*;

public class Main {
    public  boolean isPass(int value){
        if(value == 1) return  false;
        else{
            for(int i=2; i<value; i++){
                if(value % i == 0) return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int res = 0;
        for(int i=0; i<n; i++){
            int tmp = arr[i];
            while (tmp>0){
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPass(res)) answer.add(res);
            res = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();
        for(int j : M.solution(n,arr)){
            System.out.print(j + " ");
        }

    }

}