import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int solution(String s){
        int answer = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())map.put(c,map.getOrDefault(c,0)+1);
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 1 ){
                answer=i+1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}