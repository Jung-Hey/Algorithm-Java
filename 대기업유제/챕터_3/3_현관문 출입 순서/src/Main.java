import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n =arrival.length, prev=1;
        int[] answer = new int[n];
        for(int t = 0,i = 0,cnt = 0; ; t++){
            //t초에 문에 없어서 시간 건너뛰어야 하는경우
            if(enter.isEmpty() && exit.isEmpty() && i<n){
               if(t<arrival[i]){
                   t=arrival[i];
                   prev=1;
               }
            }
            //각 큐에 시간대로 넣음
            while (i < n && arrival[i]<= t){
                if(state[i]==1) exit.offer(i);
                else enter.offer(i);
                i++;
            }
            //우선순위에 따른 처리
            if(prev == 1){
                if(!exit.isEmpty()){
                    answer[exit.poll()] = t;
                    prev=1;
                }
                else{
                    answer[enter.poll()] = t;
                    prev=0;
                }
            }
            else if(prev == 0){
                if(!enter.isEmpty()){
                    answer[enter.poll()] = t;
                    prev=0;
                }
                else{
                    answer[exit.poll()] = t;
                    prev=1;
                }
            }
            cnt++;

            if(cnt==n)break;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}