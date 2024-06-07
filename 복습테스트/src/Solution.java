import java.util.*;
class Solution {
    static HashMap<Character,Integer> map;
    static LinkedList<Character> tmp;
    public void dfs(String s){
        if(tmp.size() == 6){
            String res="";
            for(char c : tmp)res+=c;
            System.out.println(res);
            return;
        }
        else{
            for(char key : map.keySet()){
                if(map.get(key) == 0 )continue;
                tmp.offer(key);
                map.put(key, map.get(key)-1);
                dfs(s);
                tmp.pollLast();
                map.put(key, map.get(key)+1);
            }
        }
    }
    public void solution(String s){
        map = new HashMap<>();
        tmp = new LinkedList<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        dfs(s);

    }

    public static void main(String[] args){
        Solution T = new Solution();
        T.solution("bbaacc");
    }
}

