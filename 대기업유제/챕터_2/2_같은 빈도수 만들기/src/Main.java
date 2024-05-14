import java.util.*;
class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<5;i++)map.put((char)(i+'a'),0);
        for(char key : s.toCharArray())map.put(key,map.getOrDefault(key,0)+1);
        ArrayList<Character> descList = new ArrayList<>(map.keySet());
        Collections.sort(descList,(e1,e2)->(map.get(e2)-map.get(e1)));
        int max = map.get(descList.get(0));
        int idx=0;
        for(char key : map.keySet())answer[idx++]= max-map.get(key);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
