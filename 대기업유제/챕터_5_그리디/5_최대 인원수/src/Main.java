import java.util.*;
class Solution {
    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;
        int []sum = new int[n+1]; // 1~5번 역중 i -> i+1 역으로 가는데 태울 수 있는 인원수
        //각 역에서 타고 내리는 사람 수 기록
        for(int [] tr : trans){
            sum[tr[0]] += tr[2];
            sum[tr[1]] -= tr[2];
        }
        for(int i=1;i<=n;i++){
            sum[i] += sum[i-1];
        }
        //승객 승차역 빠른순서대로 정렬
        Arrays.sort(bookings, (a,b)->(a[0]-b[0]) );
        LinkedList<Integer> to = new LinkedList<>();
        // 1~ n번 역까지의 운행
        for(int i=1, j=0; i<=n; i++){
            //내림
            while (!to.isEmpty() && to.peek() == i ){
                to.pollFirst();
                answer++;
            }
            //탐
            while ( j < bookings.length && bookings[j][0] == i ){
                to.offer(bookings[j][1]); // 태우고 내리는 역 추가
                //System.out.println("i : "+ i+ " "+ j +" 번 승객 태움");
                j++;
            }
            Collections.sort(to);
            //오버해서 태웠는지 체크
            while (sum[i] < to.size()){
                to.pollLast();
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}