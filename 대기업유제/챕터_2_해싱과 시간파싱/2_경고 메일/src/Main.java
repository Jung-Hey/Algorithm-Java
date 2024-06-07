import java.util.*;
class Solution {
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
    public String[] solution(String[] reports, int time){
        ArrayList<String> answer = new ArrayList<>();
        HashSet<String>set = new HashSet<>();
        HashMap<String,Integer> recentlyVisit = new HashMap<>();
        HashMap<String,Integer> totalVisitT = new HashMap<>();
        for(String v : reports){
            String[] e = v.split(" ");//e[0]=name, e[1]=time, e[3]=not use
            //in
            if(!set.contains(e[0])){
                set.add(e[0]);
                recentlyVisit.put(e[0],timeFormat(e[1]));
            }
            //out
            else{
                set.remove(e[0]);
                int inTime= recentlyVisit.get(e[0]);
                int outTime = timeFormat(e[1]);
                totalVisitT.put(e[0], totalVisitT.getOrDefault(e[0],0)+(outTime-inTime) );
            }
        }
        for(String s : totalVisitT.keySet()){
            if(totalVisitT.get(s)>time) answer.add(s);
        }
        Collections.sort(answer);

        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}