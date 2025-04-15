import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int k = sc.nextInt(); // k번째 수 

        long result = 0; // 결과로 사용할 Y 값
        int bitPosition = 0; // 현재 비트 위치

        while (k > 0) {
            // X의 현재 비트가 0인 경우에만 Y의 해당 비트를 설정할 수 있음
            if ((x & (1L << bitPosition)) == 0) {
                // k의 가장 낮은 비트를 Y의 현재 비트에 설정
                if ((k & 1) == 1) {
                    result |= (1L << bitPosition);
                }
                k >>= 1; // k를 오른쪽으로 한 비트 이동
            }
            bitPosition++; // 다음 비트 위치로 이동
        }

        System.out.println(result); // 결과 출력
    }

}
