import java.util.*;
public class Main {
    public void solution(int [] arr, int start, int end) {
        if(start>=end) return;
        int pibot = start;
        int lt= start+1;
        int rt= end;
        int tmp;
        while (lt<=rt){
            //lt가 피벗보다 큰 값을 만날때까지 lt++
            while (lt<=rt && arr[lt] <= arr[pibot]) lt++;
            //rt가 피벗보다 작은 값을 만날때까지 rt--
            while (rt>pibot && arr[rt] >= arr[pibot])rt--;
            //엇갈리는 경우로써, 피벗과 rt교체
            if(lt>rt){
                tmp = arr[rt];
                arr[rt] = arr[pibot];
                arr[pibot]= tmp;
            }
            else{
                tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
            }
        }
        solution(arr,0,rt-1);
        solution(arr,rt+1,end);

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int arr[] = {4,1,5,7,2,3,6};
        M.solution(arr, 0, arr.length-1);
        for(int i : arr ) System.out.print(i+" ");
    }
}


