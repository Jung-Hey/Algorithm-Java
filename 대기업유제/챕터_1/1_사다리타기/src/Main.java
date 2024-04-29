import java.util.*;
class Main {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        //강의안보고 푸는데 33분 소요, 단순하게 1(A)부터 사다리를 직접 타는 방식으로 구현
        /*
        for(int i=0;i<n;i++){
            int s = i+1;//1
            for(int j=ladder.length-1; j>=0; j--){
                for(int k=0;k<ladder[j].length;k++){
                    if(s == ladder[j][k]) s+=1;
                    else if(s == ladder[j][k]+1) s-=1;
                }
            }
            answer[i]= (char)(s +64) ;
        }
        */
        //강의코드 : 출력할 배열 answer에 A,B,C 등 n만큼 순서대로 담고 사다리 1이면 A,B위치를 바꾸는 간단한 시뮬로 해결
        for(int i=0;i<n;i++)answer[i] = (char)(i+65);
        for(int[] ld : ladder){
            for(int line : ld){
                char tmp = answer[line-1];//0
                answer[line-1]=answer[line];
                answer[line]= tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}