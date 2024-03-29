import java.util.*;
class Meeting implements Comparable<Meeting>{
    int s;
    int e;
    Meeting(int s,int e){
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Meeting o){
        if(this.e==o.e) return this.s - o.s;
        else return this.e - o.e ;
    }
}
public class Main {
    static int n;
    static int answer=1;
    static ArrayList<Meeting> list = new ArrayList<>();
    public void solution(){
        //내가 푼 방식 풀이와 거의 유사하다
        int max_end = list.get(0).e;
        for(int i=1;i< list.size();i++){
            if(max_end <= list.get(i).s){
                answer++;
                max_end=list.get(i).e;
            }
        }
        //풀이에서의 방식
        //        int cnt=0;
        //        int et=0;
        //        for(Time ob : arr){
        //            if(ob.s>=et){
        //                cnt++;
        //                et=ob.e;
        //            }
        //        }
        //        return cnt;
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        for(int i=0;i<n;i++){
            int s= kb.nextInt();
            int e= kb.nextInt();
            list.add(new Meeting(s,e));
        }
        Collections.sort(list);
        //for(int i=0;i< list.size();i++) System.out.println(list.get(i).s + " "+list.get(i).e);
        M.solution();
        System.out.println(answer);

    }
}


