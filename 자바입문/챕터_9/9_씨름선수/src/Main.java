import java.awt.*;
import java.util.*;
class Player implements Comparable<Player>{
    int height;
    int weight;
    Player(int height,int weight){
        this.height=height;
        this.weight=weight;
    }
    @Override
    public int compareTo(Player p){
        if(this.height==p.height) return this.weight - p.weight; //키가 같으면 몸무게 낮은순서대로 오름차순 정렬
        else return p.height - this.height; //키가 높은순서로 내림차순 정렬
    }
}
public class Main {
    static int n;
    static int answer=1;
    static ArrayList<Player> list = new ArrayList<>();
    public void solution(){
        int max_weight = list.get(0).weight;
        for(int i=1;i< list.size();i++){
            if(max_weight < list.get(i).weight){
                max_weight = list.get(i).weight;
                answer++;
            }
        }

    }
    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        for(int i=0;i<n;i++){
            int h= kb.nextInt();
            int w= kb.nextInt();
            list.add(new Player(h,w));
        }
        Collections.sort(list);
        //for(int i=0;i< list.size();i++) System.out.println(list.get(i).height + " "+list.get(i).weight);
        M.solution();
        System.out.println(answer);

    }
}


