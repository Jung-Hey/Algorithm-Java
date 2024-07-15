import java.util.*;
class Main {
    static StringBuilder sb;
    static void getMinDiffPartition(HashSet<Integer> prime, int n){
        int resL=0;
        int resR=0;
        int diff=Integer.MAX_VALUE;
        int lt=2;
        int rt=n-2;
        // 투포인터 사용
        while (lt<=rt){
            // 둘 다 소수고 두 소수의 차가 최소값을 갱신하면
            if(prime.contains(lt) && prime.contains(rt) && diff > Math.abs(lt-rt)){
                diff = Math.abs(lt-rt);
                resL = lt;
                resR = rt;
            }
            lt++;
            rt--;
        }
        sb.append(resL+" "+resR).append("\n");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt(); // 8이면 소수 2 + 6
            HashSet<Integer> prime = new HashSet<>();
            int [] arr = new int[n-1]; // n== 8 이면 2 + M 이니까 M은 6까지 소수가 필요
            // 에라토스테네스 체 , 소수만 prime에 담김
            for(int i=2; i<=n-2; i++){
                if(arr[i]==0){
                    arr[i]=1;
                    prime.add(i);
                    for(int j=i; j<=n-2; j+=i){
                        arr[j]=1;
                    }
                }
            }
            // 최소 차의 골드바흐 파티션 구함
            getMinDiffPartition(prime, n);
        }
        // 정답 출력
        System.out.println(sb);


    }
}