//내가 푼 코드
//import java.util.*;
//class Solution {
//    public int[] findYX(int n,int[][]arr){
//        int[] point = new int[2];
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                if(arr[i][j]== n){
//                    point[0]=i;
//                    point[1]=j;
//                    break;
//                }
//            }
//        }
//        return point;
//    }
//    public int solution(int[] keypad, String password){
//        int[][]arr = new int[3][3];
//        int y=-10,x=-10;
//        int idx=0;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                arr[i][j]= keypad[idx];
//                if(arr[i][j]== password.charAt(0)-'0'){
//                    y=i;
//                    x=j;
//                }
//                idx++;
//            }
//        }
//        idx=1;
//       //
//        int[]dy={-1,-1,0,1,1,1,0,-1};
//        int[]dx={0,1,1,1,0,-1,-1,-1};
//        boolean isFind=false;
//        int answer = 0;
//        String tmp= String.valueOf(password.charAt(idx-1));
//        while (!isFind){
//            boolean isMove= true;
//            //제자리는 시간안걸림
//            if( y>=0 && y<3 && x>=0 && x<3 && idx<password.length() &&password.charAt(idx)-'0'== arr[y][x] ){
//                tmp+=password.charAt(idx);
//                idx++;
//                isMove=false;
//                if(password.equals(tmp)) return answer;
//                continue;
//            }
//            for(int i=0;i<8;i++){
//                int ny = y+dy[i];
//                int nx = x+dx[i];
//                //이웃된 1초 이동
//                if( ny>=0 && ny<3 && nx>=0 && nx<3 && password.charAt(idx)-'0'== arr[ny][nx] ){
//                    y=ny;
//                    x=nx;
//                    tmp+=password.charAt(idx);
//                    idx++;
//                    answer++;
//                    isMove=false;
//                    if(password.equals(tmp)) return answer;
//                    break;
//                }
//            }
//            //2초
//            if(isMove){
//                int[] next = findYX(password.charAt(idx)-'0',arr);
//                y=next[0];
//                x=next[1];
//                answer+=2;
//                tmp+=password.charAt(idx);
//                idx++;
//                if(password.equals(tmp)) return answer;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Solution T = new Solution();
//        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));//8
//        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));//12
//        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));//13
//        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));//8
//    }
//}

import java.util.*;
class Solution {
    public int solution(int[] keypad, String password){
        int answer = 0;
        int[]dy={-1,-1,0,1,1,1,0,-1};
        int[]dx={0,1,1,1,0,-1,-1,-1};
        int[][]pad = new int[3][3];
        int[][]dist = new int[10][10]; // 1~9
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)pad[i][j]=  keypad[i*3 + j];
        }
        //dist배열 2초 초기화 및 제자리(자기자신)은 0초로 초기화
        for(int i=1;i<10;i++){
            Arrays.fill(dist[i],2);
            dist[i][i]= 0;
        }
        //pad 배열 순서대로 1초 걸리는 것은 인접행렬 방식처럼 체크.
        //ex)2에서 3으로 가는데 1초라면 dist[2][3]=1;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for(int k=0;k<8;k++){
                    int ny = i+dy[k];
                    int nx = j+dx[k];
                    if( ny>=0 && ny<3 && nx>=0 && nx<3){
                        int to = pad[ny][nx];
                        dist[from][to]=1;
                    }
                }
            }
        }
        //
        for(int i=1;i<password.length();i++){
            int from = password.charAt(i-1)-'0';
            int to = password.charAt(i)-'0';
            answer+=dist[from][to];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}