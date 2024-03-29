import java.util.*;
class Visiter implements Comparable<Visiter>{
    int time;
    char type;
    Visiter(int time,char type){
        this.time=time;
        this.type=type;
    }
    @Override
    public int compareTo(Visiter o){
        if(this.time==o.time) return this.type - o.type;
        else return this.time - o.time ;
    }
}
public class Main {
    static int n;
    static int answer=Integer.MIN_VALUE;
    static ArrayList<Visiter> list = new ArrayList<>();
    public void solution(){
        int cnt=0;
        for(Visiter v: list){
            if(v.type=='s')cnt++;
            else cnt--;
            answer=Math.max(answer,cnt);
        }
    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        for(int i=0;i<n;i++){
            int s= kb.nextInt();
            int e= kb.nextInt();
            list.add(new Visiter(s,'s'));
            list.add(new Visiter(e,'e'));
        }
        Collections.sort(list);
        for(int i=0;i< list.size();i++) System.out.println(list.get(i).time + " "+list.get(i).type);
        M.solution();
        System.out.println(answer);

    }
}


