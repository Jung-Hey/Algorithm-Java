import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 정수에 1을 더하고 이진수로 변환 후 '0'을 '4'로, '1'을 '7'로 변환
        String result = Integer.toBinaryString(num + 1).replace('0', '4').replace('1', '7');

        // 첫 번째 문자 제거하고 출력 (index 1부터)
        System.out.println(result.substring(1));


    }
}
