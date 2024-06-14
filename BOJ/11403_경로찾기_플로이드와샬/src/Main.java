/**
 * 플로이드 와샬 이것만 기억하자
 * 2 -> 3 정점으로 간다면 즉 i -> j로  간다면, 거쳐가는 노드(k)를 계산해야 함.
 * 핵심은 i -> j VS i -> k + k -> j 가중치 비교
 */
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]= sc.nextInt();
            }
        }
        //solve
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][k]==1 && arr[k][j]==1) arr[i][j]=1;
                }
            }
        }
        //output
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
