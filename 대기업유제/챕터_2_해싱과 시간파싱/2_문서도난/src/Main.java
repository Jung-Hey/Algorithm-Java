import java.util.*;
class Solution {
    class Enter implements Comparable<Enter>{
        String name;
        int time;
        public Enter(String name, int time){
            this.name=name;
            this.time=time;
        }
        @Override
        public int compareTo(Enter e){
            return this.time-e.time;
        }
    }
    //시간 분단위로 변환
    public int timeFormat(String time){
        int res=0;
        String[]fm =time.split(":");
        int m = Integer.parseInt(fm[1]);
        int h = Integer.parseInt(fm[0]);
        res+= m;
        res+= (h*60);
        return res;
    }
    public String[] solution(String[] reports, String times){
        ArrayList<String> answer = new ArrayList<>();
        String [] targetTime = times.split(" ");
        int from = timeFormat(targetTime[0]);
        int to = timeFormat(targetTime[1]);
        ArrayList<Enter> list = new ArrayList<>();
        for(String rp : reports){
            String[] r = rp.split(" ");
            list.add(new Enter(r[0],timeFormat(r[1])));
        }
        Collections.sort(list);
        for(Enter tmp : list){
            if(tmp.time>=from && tmp.time<=to) answer.add(tmp.name);
            if(tmp.time>to)break;
        }
        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}