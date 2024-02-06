import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(1);
       //배열을 사용해서 구현
        for(int i =2; i<n; i++){
            answer.add(answer.get(i-1) +answer.get(i-2));
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i : M.solution(n)){
            System.out.print(i+" ");
        }

        //배열 사용하지 않고 구현
        //1 1 2    3 5 8 13 21 34 55
//        int a=1,b=1;
//        int c;
//        System.out.print(a+" "+b+" ");
//        for(int i=2; i<n; i++){
//            c= a+b;
//            System.out.print(c+" ");
//            a=b;
//            b=c;
//        }

    }

}