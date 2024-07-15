import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        // 1 5 2 1 4 3 4 5 2 1
        int [] arrBt = new int[n];
        for(int i=0; i<n; i++){
            int tmp = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i]> arr[j]){
                    tmp = Math.max(tmp, arrBt[j]);
                }
            }
            arrBt[i] = tmp+1;
        }
        //System.out.println(Arrays.toString(arrBt));
        int [] arrBtReverse = new int[n];
        for(int i=n-1; i>=0; i--){
            int tmp = 0;
            for(int j=i+1; j<=n-1; j++){
                if(arr[i] > arr[j]){
                    tmp = Math.max(tmp, arrBtReverse[j]);
                }
            }
            arrBtReverse[i] = tmp+1;
        }
        //System.out.println(Arrays.toString(arrBtReverse));
        int answer=0;
        for(int i=0; i<n; i++){
            answer= Math.max(arrBt[i]+arrBtReverse[i], answer);
        }
        System.out.println(answer-1);



    }

}

/*

10
1 5 2 1 4 3 4 5 2 1
[1, 2, 2, 1, 3, 3, 4, 5, 2, 1]
[5, 1, 4, 4, 2, 3, 2, 1, 1, 1]

 */