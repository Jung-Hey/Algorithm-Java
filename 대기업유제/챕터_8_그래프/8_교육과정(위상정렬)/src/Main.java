import java.util.*;
class Solution {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        //과목과 번호 해싱
        for(int i=0; i<n; i++){
            map.put(subjects[i],i);
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(String s : course){
            //a듣기 위해서 b를 먼저들어야 함.  b -> a
            int a = map.get(s.split(" ")[0]);
            int b = map.get(s.split(" ")[1]);
            indegree[a]++;
            graph.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        //System.out.println(Arrays.toString(indegree));
        for(int i=0; i<n; i++) {
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int pre = q.poll();
            answer.add(subjects[pre]);
            for(int x : graph.get(pre)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.offer(x);
                }
            }
        }
        System.out.println(answer);

        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}