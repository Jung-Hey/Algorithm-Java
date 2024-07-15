import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 일곱난쟁이 문제와 유사
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);
        int idx=1;
        while (!q.isEmpty()){
            int tmp = q.poll();
            if(k == idx++){
                idx=1;
                list.add(tmp);
            }
            else q.offer(tmp);
        }
        for(int i=0; i< list.size(); i++){
            if(i< list.size()-1){
                sb.append(list.get(i)).append(", ");
            }
            else{
                sb.append(list.get(i));
            }
        }
        sb.append(">");
        System.out.println(sb);

    }
}

