import java.util.*;

public class Main {
    static int n;
    static int[] dy,arr;

    public void solution(){
        int answer=0;
        dy[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    max = Math.max(max,dy[j]);
                }
            }
            dy[i]=max+1;
            answer=Math.max(answer,dy[i]);
        }
        System.out.println(answer);


    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr=new int[n];
        dy=new int[n];
        for(int i=0;i<n;i++) arr[i]= kb.nextInt();
        M.solution();


    }
}


