import java.util.Scanner;

public class Main {
    // 조건 X + Y = X | Y
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int k = sc.nextInt(); // k번째 수
        // X의 이진 표현에서 0인 비트 위치를 저장
        StringBuilder xBinary = new StringBuilder(Long.toBinaryString(x)).reverse();
        int zeroCount = 0;
        long result = 0;

        for (int i = 0; ; i++) {
            // X의 비트 길이를 초과하면 해당 비트는 0으로 간주
            char xBit = (i < xBinary.length()) ? xBinary.charAt(i) : '0';

            if (xBit == '0') {
                // k의 현재 비트가 1이면 결과에 해당 비트를 설정
                if ((k & (1L << zeroCount)) != 0) {
                    result |= (1L << i);
                }
                zeroCount++;
                // 모든 비트를 확인했으면 종료
                if ((1L << zeroCount) > k) break;
            }
        }
    
        System.out.println(result);
    }

}
