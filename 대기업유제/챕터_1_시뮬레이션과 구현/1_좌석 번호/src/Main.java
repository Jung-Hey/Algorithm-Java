import java.util.*;
class Solution {
    // * 오른쪽으로 표를 돌리면  좌석번호 패턴을 찾을 필요없이 answer[0]=y+1; 로 가능
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c*r) return answer; // 앉지 못하는 경우 종료
        int[] dy= {-1,0,1,0};
        int[] dx= {0,1,0,-1};
        int[][]arr = new int[c][r];
        int cnt=1 ,d=1;
        //시작위치
        int y=0 ,x=0;
        arr[y][x]=1;
        while (cnt<k){
            int ny= y+dy[d];
            int nx= x+dx[d];
            boolean pass = ny>=0 && ny < c &&  nx>=0 && nx < r && arr[ny][nx]==0;
            if(!pass){
                d= (d+1) % 4;
                continue;
            }
            arr[ny][nx]=1;
            cnt++;
            y=ny;
            x=nx;
        }
        answer[0]=y+1;
        answer[1]=x+1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}