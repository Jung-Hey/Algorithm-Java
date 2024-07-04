import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        //테스트케이스
        for(int i=0; i<t;i++){
            int l = sc.nextInt();//나무 길이
            int n = sc.nextInt();//개미 수
            int max=0;
            int min=0;
            int half = l/2;
            for(int j=0;j<n;j++){
                int ant = sc.nextInt();
                //절반이하 위치는 0쪽으로 가야 빨리 떨어짐
                if(ant <= half){
                    //최소경우 ex) 2위치에서 0으로 가야 빨리 떨어짐
                    min = Math.max(min,ant);
                    //최대경우 ex) 2위치에서 10(l)으로 가야 빨리 떨어짐
                    max = Math.max(max,l-ant);
                }
                else{
                    min = Math.max(min,l-ant);
                    max = Math.max(max,ant);
                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}