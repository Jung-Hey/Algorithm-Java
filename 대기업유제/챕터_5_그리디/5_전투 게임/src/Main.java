import java.util.*;
class Solution {
    static class student implements Comparable <student>{
        int idx;
        char team;
        int attack;
        student(int idx, char team, int attack){
            this.idx=idx;
            this.team=team;
            this.attack=attack;
        }
        @Override
        public int compareTo(student s){
            //같은팀이면 점수 오름차순
            return this.attack - s.attack;

        }

    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] tmp = students[i].split(" ");
            list.add(new student(i,tmp[0].charAt(0),Integer.parseInt(tmp[1])));
        }
        Collections.sort(list);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=1, j=0, total=0; i<n;i++){
            for(j=j; j<n;j++){
                if(list.get(i).attack > list.get(j).attack){
                    total += list.get(j).attack;
                    map.put(list.get(j).team, map.getOrDefault(list.get(j).team,0)+list.get(j).attack);
                }
                else break;
            }
            answer[list.get(i).idx] = total - map.getOrDefault(list.get(i).team,0);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}