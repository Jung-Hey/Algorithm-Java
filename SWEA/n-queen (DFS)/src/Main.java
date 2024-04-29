import java.util.*;
public class Main {
    static int n,answer;
    static int[] arr;
    public boolean valid(int i) {
        for (int j=0; j<i; j++) {
            //열에 퀸이 있는지 판별
            if (arr[i] == arr[j]) return false;
            //대각선에 일치하는게(퀸이) 있는지 판별
            if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) return false;
        }
        return true;
    }
    public void dfs(int l){
        if(l==n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            arr[l] = i;
            // 해당 arr(행)과 i(열)에 퀸을 놓을 수 있는지 확인
            if (valid(l)) dfs(l + 1);
            //if조건을 안걸고 dfs(l + 1) 를 하면 중복순열이 되면서 모든 경우의 수를 if(l==n)인순간 만듦
        }
    }
    // arr [] = {0, 3, 1, 2} 는
    // 2차원 배열로 했을때 다음과 같다 (1은 퀸이 있다는 뜻)
    // 1 0 0 0
    // 0 0 0 1
    // 0 1 0 0
    // 0 0 1 0

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr=new int[n];
        M.dfs(0);
        System.out.println(answer);
    }
}