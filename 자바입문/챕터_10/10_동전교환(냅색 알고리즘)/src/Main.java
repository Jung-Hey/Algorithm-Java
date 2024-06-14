import java.util.*;

public class Main {
    static int n,target;
    static int answer=Integer.MAX_VALUE;
    static Integer[] arr,dy;

    public int solution(){
        dy[0]=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i]; j<=target;j++){
                dy[j]= Math.min(dy[j],dy[j-arr[i]]+1);
            }
            System.out.println(Arrays.toString(dy));
        }
        return dy[target];
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        arr=new Integer[n];
        for(int i=0;i<n;i++) arr[i]= kb.nextInt();
        target=kb.nextInt();
        dy= new Integer[target+1];
        Arrays.fill(dy,Integer.MAX_VALUE);
        System.out.println(M.solution());
    }
}


