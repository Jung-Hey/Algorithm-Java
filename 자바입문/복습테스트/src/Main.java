import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int[][] arr = new int[3][2];
        arr[0] = new int[] {0, 1};
        arr[1] = new int[] {3, 2};
        arr[2] = new int[] {4, 5};

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

    }
}