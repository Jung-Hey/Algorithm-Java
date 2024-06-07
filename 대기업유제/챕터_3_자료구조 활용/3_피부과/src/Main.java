import java.util.*;
class Solution {
    class laserTime{
        int from;
        int to;
        laserTime(int from,int to){
            this.from=from;
            this.to=to;
        }
    }
    public int getTime(String t){
        int res=0;
        String [] time = t.split(":");
        res=Integer.parseInt(time[1])+Integer.parseInt(time[0])*60;
        return res;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        //내 코드 : 큐 없이 클래스 사용해서 단순비교
//        ArrayList<laserTime> list = new ArrayList<>();
//        for(String e : enter){
//            String [] info = e.split(" ");
//            int from = getTime(info[0]);
//            int needT = laser[Integer.parseInt(info[1])];
//            list.add(new laserTime(from,from+needT));
//        }
//        for(int i=0;i<list.size();i++){
//            //if(list.size()-i < answer)return answer;
//            int cnt=0;
//            laserTime a = list.get(i);
//            for(int j=i+1;j<list.size();j++){
//                laserTime b = list.get(j);
//                if(a.to>b.from)cnt++;
//                else break;
//            }
//            answer=Math.max(answer,cnt);
//        }
        //큐
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for(int t = fT; t <= 1200; t++){
            //받을 손님이 있고 다음 대기자가 시술시간이 되었으므로 대기실(Q)에 추가
            if(pos < n && t == inList[pos][0]){
                //건너뛰는 경우로 대기실(Q)에 사람이 없고(Q에 사람이 없으면 fT증가못하기때문)
                //fT보다 다음사람의 진료시작이간이 뒤기 때문에 fT를 조정해야한다.
                if(Q.isEmpty() && fT < inList[pos][0]) fT = inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            //시술끝났으면
           if(!Q.isEmpty() && t==fT){
               int idx = Q.poll();
               fT+=laser[idx];
           }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();

        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}