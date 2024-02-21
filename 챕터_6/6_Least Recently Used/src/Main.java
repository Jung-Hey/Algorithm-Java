import java.util.*;
public class Main {
    public int[] solution(int size ,int n, int[] arr){
        // LRU 알고리즘의 핵심 3가지.
        // 1. Miss이건 Hit이건 cache[0] = x;
        // 2. Miss면 배열 최우측에서 1번 idx까지 값 밀어냄 ( cache[i] = cache[i-1])
        // 3. Hit이면 hit한 지점 ~ 1번 idx까지 i--되면서 값 밀어냄
        int [] cache = new int[size];
        for(int x : arr){
            int idx = -1;
            for(int i=0; i<size; i++) if(cache[i] == x) idx = i;
            //miss
            if(idx == -1){
                for(int i=size-1; i>=1; i--) cache[i] = cache[i-1];
            }
            //hit
            else{
                for(int i=idx; i>=1; i--) cache[i] = cache[i-1];
            }
            cache[0] = x;
        }

        return cache;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt(); // 캐시의 크기
        int n = kb.nextInt(); // 작업들의 크기
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        for(int j : M.solution(s,n,arr)) System.out.print(j+" ");


    }
}


