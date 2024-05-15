import java.util.*;
class Solution {
    public int getTime(String str){
        String[] time = str.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        //큐
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> q = new LinkedList<>(); // 대기실
        q.offer(inList[0][1]);
        int ft = inList[0][0];
        for(int pos=1, t=ft; t<=1200; t++){
            // 진료가 남았고 다음 진료시간이 되면
            if( pos < n && t == inList[pos][0] ){
                //skip
                if(q.isEmpty() && ft < inList[pos][0] ) ft=inList[pos][0];
                q.offer(inList[pos][1]);
                pos++;
            }
            // 진료종료시간이 되면 대기실에 한명 빼고 다음 진료종료시간 갱신
            if(!q.isEmpty() && t==ft ){
                ft += laser[q.poll()];
            }
            answer = Math.max(answer,q.size());
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
//        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
//        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}