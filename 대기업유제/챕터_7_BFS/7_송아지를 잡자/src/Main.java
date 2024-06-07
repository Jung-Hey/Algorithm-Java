import java.util.*;
class Solution {
    public int solution(int s, int e){
        int answer = 0;
        int[][] ch = new int [2][200001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        ch[0][s]=1;
        //int ej = 1;//송아지 이동거리
        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            L++;
            for(int i=0; i<len; i++){
                int x = q.poll();
                for(int nx : new int[] {x-1, x+1, x*2}){
                    //레벨 2에 방문한 위치는 4,6 ... 짝수 레벨에서 또 방문하므로 짝수 홀수 레벨 구분해서
                    //방문 안한 위치만 가지를 뻗어 복잡도를 줄임
                    if(nx>=0 && nx <= 200000 && ch[L%2][nx]==0){
                        ch[L%2][nx]=1;
                        q.offer(nx);
                    }
                }
            }
            e = e + L; //L은 초라고 생각해야 함. ex> e=12, L=4라면  4초 시점에 송아지의 위치는 12
            if(e > 200000) return -1;
            if(ch[L%2][e]==1) return L;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}