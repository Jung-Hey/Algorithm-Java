import java.util.*;
class Truck {
    int weight;
    int move;
    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }
    public void moving() {
        move++;
    }
}
public class Main {
        public int solution(int bridge_length, int weight, int[] truck_weights){
            Queue<Truck> waitQ = new LinkedList<>();
            Queue<Truck> moveQ = new LinkedList<>();
            for(int t : truck_weights) waitQ.offer(new Truck(t));//대기큐 세팅
            int answer=0;
            int allWeight=0;
            while(!waitQ.isEmpty() || !moveQ.isEmpty()){
                answer++;
                //이동 큐 비었을 때 넣어주고 continue
                if(moveQ.isEmpty() && !waitQ.isEmpty()){
                    Truck t = waitQ.poll();
                    allWeight+=t.weight;
                    moveQ.offer(t);
                    continue;
                }
                //이동 큐 트럭들 이동
                for(Truck t: moveQ)t.moving();
                //다리를 다 지난 트럭은 뺌
                if(moveQ.peek().move>bridge_length){
                    Truck t= moveQ.poll();
                    allWeight-=t.weight;
                }
                //트럭이 이동 큐로 더 들어올 수 있을때
                if(moveQ.size()<bridge_length && !waitQ.isEmpty() && allWeight+waitQ.peek().weight <= weight){
                    Truck t = waitQ.poll();
                    allWeight+=t.weight;
                    moveQ.offer(t);
                }
            }

            return answer;
        }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int bridge_length= 2;
        int weight= 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(M.solution(bridge_length,weight,truck_weights));
    }
}




//import java.util.*;
//public class Main {
//    public int solution(int bridge_length, int weight, int[] truck_weights){
//        int answer = 0;
//        int sum=0; //다리위의 트럭들의 무게
//        Queue<Integer> q = new LinkedList<Integer>();
//        for(int truck : truck_weights){
//            while(true){
//                //다리에 트럭 없는 경우
//                if(q.isEmpty()){
//                    q.add(truck);
//                    sum+=truck;
//                    answer++;
//                    break;
//                }
//                //다리가 꽉 찬 경우
//                else if(q.size()==bridge_length) sum-=q.poll();
//                else{
//                    //다리에 트럭을 실을 수 있을 경우
//                    if(sum+truck<=weight){
//                        q.add(truck);
//                        sum+=truck;
//                        answer++;
//                        break;
//                    }
//                    else{
//                        //다리에 트럭 무게가 초과인 경우
//                        //가상으로 0을 채워줌
//                        q.add(0);
//                        answer++;
//                    }
//                }
//            }
//        }
//        //마지막 트럭이 빠져나오는 시간
//        answer +=bridge_length;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main M = new Main();
//        Scanner kb = new Scanner(System.in);
//        int bridge_length= 2;
//        int weight= 10;
//        int[] truck_weights = {7,4,5,6};
//        System.out.println(M.solution(bridge_length,weight,truck_weights));
//    }
//}
//
