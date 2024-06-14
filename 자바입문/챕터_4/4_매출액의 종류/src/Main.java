import java.util.*;
public class Main {
    public ArrayList<Integer> solution( int n, int k, int[] arr ){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        //  TIME LIMIT EXCEEDED
//        for(int i=0; i<= n-k;i++){
//            for(int j=i; j< i+k; j++){
//                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
//                //System.out.print(arr[j]+" ");
//            }
//            //System.out.println();
//            answer[i] = map.size();
//            map.clear();
//        }
//
//        //System.out.println("최종 : "+ Arrays.toString(answer));

        // 투포인터 방식으로 잘 고친거 같은데 이래도 시간제한초과 ㅠㅠ
//        int lp=0, rp = k-1;
//        while (lp<n && rp<n){
//            for(int i=lp; i<= rp ;i++){
//                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
//                //System.out.println("i :"+i+ " lp :"+lp+ " rp:"+rp);
//            }
//            answer.add(map.size());
//            map.clear();
//            lp++;
//            rp++;
//        }

        //3트만에 정답 : 풀이에서의 k-1과 다르게 나는 풀때 k만큼 윈도우 생성
        for(int i=0; i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        answer.add(map.size());
        //슬라이딩
        int lp=1, rp= k;
        for(int i=lp; i<=n-k; i++){
            // lp빼기
            map.put(arr[lp-1],map.get(arr[lp-1])-1);
            if( map.get(arr[lp-1]) == 0)  map.remove(arr[lp-1]);
            //rp 더하기
            map.put(arr[rp],map.getOrDefault(arr[rp],0)+1);
            answer.add(map.size());
            lp++;
            rp++;
        }

        //풀이에서의 코드
//        for(int i=0; i<k-1; i++){
//            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
//        }
//        int lt=0;
//        for(int rt=k-1; rt<n; rt++){
//            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
//            answer.add(map.size());
//            map.put(arr[lt], map.get(arr[lt])-1);
//            if(map.get(arr[lt])==0) map.remove(arr[lt]);
//            lt++;
//        }


        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = kb.nextInt();
        for(int j:M.solution(n,k,arr)) System.out.print(j+" ");

    }
}


