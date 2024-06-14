import java.util.*;
class Main {
    static int n;
    static int[] arr;
    public static int getLowerBound(int target){
        int lt = 0;
        int rt = arr.length;
        // lt가 rt랑 같아질 때 까지
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] >= target) {
                rt = mid;
            }
            else {
                lt = mid + 1;
            }
        }

        return lt;
    }
    public static int getUpperBound(int target){
        int lt = 0;
        int rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (target < arr[mid]) {
                rt = mid;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr= new int[n];
        for(int i=0; i<n; i++) arr[i]= sc.nextInt();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int target = sc.nextInt();
            sb.append(getUpperBound(target)- getLowerBound(target)).append(" ");
        }
        System.out.println(sb);

    }
}