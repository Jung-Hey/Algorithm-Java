import java.util.*;
class Solution {
    public int solution(String s){
        int answer = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())map.put(c,map.getOrDefault(c,0)+1);
        HashSet<Integer>set= new HashSet<>();
        for(char key : map.keySet()){
            if(set.contains(map.get(key))){
                int num = map.get(key);
                while ( num > 0){
                    answer++;
                    num--;
                    if(!set.contains(num))break;
                }
                if(num>0) set.add(num);
            }
            else set.add(map.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}