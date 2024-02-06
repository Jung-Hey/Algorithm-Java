import java.util.*;
public class Main {
    public int solution(int n,int m, int[][] arr){
        int answer=0;
        //느낀점 : 해설을 보고야 풀 수 있었는데, 입력이 어떻게 들어오건 n이 4일때
        //들어오는 학생은 1~4라는 것을 알고 3,1,1,2 이렇게 들어온다고 헷갈리지 말고
        //가장 상위 반복문2개 에서 학생들의 경우에 수를 찾고 내부에 k,s반복문에서 조건을 주면 어렵지 않게 풀 수 있다.

        //for문 i,j는 멘토링 짝을 맞추어 조건을 검사하기 위해 필요
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int cnt=0;
                for(int k=0;k<m;k++){//k는 시험의 횟수
                    int pi=0, pj=0;
                    for(int s=0;s<n;s++){ // s는 등수
                        if(arr[k][s]==i) pi=s;
                        if(arr[k][s]==j) pj=s;
                    }
                    // 등수가 낮으면 cnt증가
                    if(pi<pj) cnt++;
                }
                //cnt가 m과 같다는 말은 모든 시험에서 등수가 높다는 뜻이다.
                if(cnt == m) answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 학생 수
        int m = kb.nextInt(); // 시험 횟수
        int [][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n,m,arr));
    }


}


