import java.util.*;
class Solution {
    static ArrayList<String> answer;
    static Deque<Character> q;
    static HashMap<Character, Integer> map;
    static int len;

    public void dfs(){
        if(q.size() == len){
            String res="";
            for(char c : q) res += c;
            answer.add(res);
        }
        else{
            for(char key : map.keySet()){
                if(map.get(key) == 0) continue;
                q.addFirst(key);
                q.addLast(key);
                map.put(key, map.get(key)-2);
                dfs();
                q.pollFirst();
                q.pollLast();
                map.put(key, map.get(key)+2);
            }
        }
    }
    public String[] solution(String s){
        answer = new ArrayList<>();
        q = new LinkedList<>();
        map = new HashMap<>();
        len = s.length();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        char mid = '#';
        char singleCnt=0;
        for(char key : map.keySet()){
            if( (map.get(key) % 2) == 1){
                mid = key;
                singleCnt++;
            }
        }
        if(singleCnt > 1) return new String[] {};
        if(mid != '#') {
            q.add(mid);
            map.put(mid, map.get(mid)-1);// 하나만 쓰인 문자 mid에 넣었으니 0으로 만듦
        }
        dfs();

        return answer.stream().toArray(String[] :: new);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}