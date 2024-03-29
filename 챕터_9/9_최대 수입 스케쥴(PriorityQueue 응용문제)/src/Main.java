import java.util.*;
class Edue implements Comparable<Edue>{
    int pay;
    int day;
    Edue(int pay,int day){
        this.pay=pay;
        this.day=day;
    }
    @Override
    public int compareTo(Edue e){
        if(this.day==e.day) return e.pay- this.pay;
        else return e.day- this.day;
    }
}
public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Edue>list = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(){
        int answer=0;
        Collections.sort(list);
        int j=0;
        //max만큼 반복하는 이유는 day안에 강의를 해야하는 조건이니까
        for(int i=max;i>0;i--){
            for(;j<n;j++){
                //핵심코드로 max=3이면 list에 3보다 작은건 pQ에 안넣음
                if(i > list.get(j).day)break;
                pQ.offer(list.get(j).pay);
            }
            if(!pQ.isEmpty())answer+= pQ.poll();

        }
        return answer;
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        for(int i=0;i<n;i++){
            int pay= kb.nextInt();
            int day= kb.nextInt();
            max = Math.max(max,day);
            list.add(new Edue(pay,day));
        }

        //for(int i=0;i< list.size();i++) System.out.println(list.get(i).height + " "+list.get(i).weight);
        System.out.println(M.solution());

    }
}


