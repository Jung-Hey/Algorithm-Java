import java.util.*;
public class Main {
    public int count(int[]arr, int capacity){
        //최소 비디오를 구하는 메소드
        // cnt를 1로 초기화한 이유는 최소 1장의 비디오가 만들어지기 때문임
        int sum=0, cnt=1;
        for(int i : arr){
            //용량을 초과하는 경우
            if(sum+i > capacity){
                cnt++;
                sum=i;
            }
            else{
                sum+=i;
            }
        }
        return cnt;
    }
    public int solution(int n ,int m, int[] arr){
        int answer = 0;
        //lt는 한 비디오 중에서 가장 용량이 큰것으로 한다. 왜냐햐면 어떤 비디오를 담든 최소 가장 큰 용량이 필요하기 때문에.
        //rt는 모든 비디오 용량을 합한 것으로 한다.
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        //이진탐색은 언젠가 lt가 rt보다 커진다
        while (lt<=rt){
            int mid = (lt+rt) / 2;
            // (중요) 최소 비디오를 구하는 조건식이다 만약 count에서 2개의 비디오가 만들어졌다고 가정한다.
            // 입력 m이 3이라고 가정하면 count에서 2개의 비디오가 만들어지면 당연히 3개,4개의 비디오도 만들 수 있다는 소리이다.
            // 그렇기 때문에 더욱 최소값을 구하기 위해 rt의 범위를 줄인다.
            if(count(arr,mid) <= m){
                answer = mid;
                rt = mid-1;
            }
            else lt = mid+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++)arr[i]= kb.nextInt();
        System.out.print(M.solution(n,m,arr));


    }
}


