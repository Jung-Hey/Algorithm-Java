import java.util.*;
class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    public int solution(int n, int m, int [] arr){
        int answer = 0;
        Queue<Person> que = new LinkedList<>();
        for(int i=0;i<n;i++)que.offer(new Person(i,arr[i]));
        while (!que.isEmpty()){
            Person tmp = que.poll();
            for(Person x : que){
                if(x.priority > tmp.priority){
                    que.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == m) return  answer;
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=kb.nextInt();
        System.out.print(M.solution(n,m,arr));
    }
}


