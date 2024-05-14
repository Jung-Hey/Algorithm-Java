import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        //1) 1초 전에 현관문을 사용한 적이 없으면 나가는 사원이 먼저 현관문을 이용합니다.
        //2) 1초 전에 나가는 사원이 현관문을 이용했다면 나가는 사원이 먼저 현관문을 이용합니다.
        //3) 1초 전에 들어오는 사원이 문을 이용했다면 들어오는 사원이 먼저 현관문을 이용합니다.
        //4) 같은 방향으로 가려고 하는 사람이 여러명이라면 그 중 사원번호가 가장 작은 사람이 우선 현관문을 이용합니다.
        LinkedList<Integer> enter = new LinkedList<>();
        LinkedList<Integer> exit = new LinkedList<>();
        for(int i=0, t=0, cnt=0, prev=1; ; t++){
            //시간 건너뛰어야 하는 경우
            if(enter.isEmpty() && exit.isEmpty() && i<n){
                if(t < arrival[i]) t = arrival[i];
            }
            //t시간까지 들어온 순서(i)대로 나가는지 들어오는지 구분해서 넣음
            while (i<n && arrival[i] <= t){
                if(state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }
            if(prev==1){
                if(!exit.isEmpty()){
                    answer[exit.poll()] = t;
                    prev=1;
                }
                else{
                    answer[enter.poll()] = t;
                    prev=0;
                }
            }
            else if(prev==0){
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
            if(cnt == n)break;
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