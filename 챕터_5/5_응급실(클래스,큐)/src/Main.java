import java.util.*;
public class Main {
    public class Person{
        int idx;
        int priority ;
        public Person(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int n,int m, int [] arr){
        //5 2
        //60 50 70 80 90      ==> 3
        //*응급실문제의 규칙
        //1.poll()을 tmp클래스 변수에 저장한다음 큐를 돌며 큰 값이 있는지 비교.
        //2-1. 큰 값이 있을때 : 비교중인 값을 다시 큐에 offer시킴
        //2-2. 큰 값이 없을때 : 지금 비교중인 tmp가 가장 큰 값(우선순위)기 때문에 answer++ 시키고 tmp의 dix가
        //입력으로 들어온 idx이면 바로 리턴.
        int answer = 0;
        Queue<Person> que = new LinkedList<>();
        for(int i=0;i<n;i++)que.offer(new Person(i,arr[i]));
        while (!que.isEmpty()){
            Person tmp = que.poll();
            for(Person p : que){
                if(tmp.priority < p.priority){
                    que.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(m == tmp.idx) return  answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr= new int[n];
        for(int i=0; i<n; i++) arr[i]= kb.nextInt();
        System.out.print(M.solution(n,m,arr));

    }
}


