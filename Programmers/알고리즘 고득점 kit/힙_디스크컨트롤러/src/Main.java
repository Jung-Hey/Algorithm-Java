import java.util.*;
class Process implements Comparable <Process>{
    int s,e;
    Process(int s,int e){
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Process p){
        return this.e - p.e;
    }
}
public class Main {
    int[][] arr;
    static int n,m;
    public int solution(int[][] jobs){
        int sum = 0;
        // jobs 배열 요청시점 오름차순 정렬
        Arrays.sort( jobs,(o1,o2) -> (o1[0] - o2[0]) );
        PriorityQueue<Process> pQ = new PriorityQueue<>();
        int endTime = 0; // 프로세스 수행될때마다의 종료시간
        int idx = 0; // 배열 인덱스
        int cnt = 0; // 프로세스 수행 개수
        //들어온 요청을 다 처리할떄까지
        while (cnt< jobs.length){
            //큐에 넣는 기준은, 즉 작업을 처리하기 위한 기준은 프로세스의 요청시점이 endTime보다 같거나 작아야 함
            //왜냐하면 jobs[idx][0]<=endTime 이 조건이 안되면 다음 프로세스 시작까지 시간이 뜬다는 것임
            while (idx<jobs.length && jobs[idx][0]<=endTime){
                System.out.println(jobs[idx][0]+" "+jobs[idx][1]);
                pQ.offer(new Process(jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            if(pQ.isEmpty()){
                endTime=jobs[idx][0];
                System.out.println("빔 endTime : "+endTime);
            }
            else{
                Process tmp = pQ.poll();
                sum+= tmp.e+endTime-tmp.s;
                endTime+=tmp.e;
                System.out.println("endTime : "+endTime + " sum : "+sum);
                cnt++;
            }
        }
        return sum / jobs.length;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int [][] jobs = {{0,3},{4,9},{5,6}};
        System.out.println(M.solution(jobs));
    }
}