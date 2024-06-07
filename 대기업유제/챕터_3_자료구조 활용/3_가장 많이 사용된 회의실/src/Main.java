import java.util.*;
class Solution {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i=0;i<n;i++) rooms.add(i);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a,b)->(a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]) );
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]) );
        for(int[] m : meetings){
            // 다음 회의가 6시 시작,  진행중인 회의의 종료시간이 5시면 진행중인 회의 종료시키기
            while (!ends.isEmpty() && ends.peek()[0] <= m[0] ) rooms.add(ends.poll()[1]); //방 비움
            // 회의실 있을떄
            if(!rooms.isEmpty()){
                int room = rooms.pollFirst();
                res[room]++;
                ends.offer(new int[] { m[1], room } );// 진행중인 회의로 처리 (종료시간과 회의실 번호)
            }
            else{
                //회의실 없어서 다음 회의가 기다려야 하는경우
                if(!ends.isEmpty()){
                    int [] end = ends.poll();
                    rooms.remove(end[1]);// 진행중인 회의실 방 비움
                    //기다렸다 새 회의 들어감.
                    res[end[1]]++;
                    //기다린만큼 종료시간 계산. ex) 6 ~ 9 회의인데 ends에 7시에 끝나는 회의다 하면  1시간 기다렸으니 6~9회의는
                    // 9에 끝나는게 아닌 10에 끝남
                    ends.offer(new int[] { (end[0]-m[0])+m[1] , end[1] } );
                }
            }
        }
        //가장 많이 사용된 회의실 출력 횟수가 동일하면 방번호 낮은방 출력
        //System.out.println(Arrays.toString(res));
        int tmp=0;
        for(int i=0;i<n;i++){
            if( tmp < res[i] ){
                tmp = res[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}