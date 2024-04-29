import java.util.*;
public class Main {
        public int[] solution(int [] progresses, int [] speeds){
            ArrayList<Integer> answer = new ArrayList<>();
            int idx=1;//일수
            int i=0;
            for(;i<progresses.length;i++){
                int cnt=1;
                // 100이상 될때까지 반복
                while(! (progresses[i]+(speeds[i]* idx) >= 100)) idx++;
                for(int j=i+1;j<progresses.length;j++){
                    if((progresses[j]+(speeds[j]* idx) >= 100)){
                        i+=1;
                        cnt++;
                    }
                    else break;
                }
                answer.add(cnt);
            }
            //배열로 리턴
            return answer.stream().mapToInt(v -> v).toArray();
        }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds= {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(M.solution(progresses,speeds)));
    }
}

