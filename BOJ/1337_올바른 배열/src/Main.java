import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            int num= sc.nextInt();
            arr[i]= num;
            set.add(num);
        }
        //정렬
        Arrays.sort(arr);
        int answer=0;
        for(int i=0; i<n; i++){
            int tmp=0;
            //1씩 차이나는 수 체크
            if(set.contains(arr[i]+1)) tmp++;
            if(set.contains(arr[i]+2)) tmp++;
            if(set.contains(arr[i]+3)) tmp++;
            if(set.contains(arr[i]+4)) tmp++;
            answer=Math.max(tmp,answer);
        }
        answer+=1;
        //output
        System.out.println(5-answer);
    }
}