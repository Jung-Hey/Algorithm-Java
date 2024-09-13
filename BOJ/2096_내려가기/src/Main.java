import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n+1][3];
        int [][] minArr = new int[n+1][3];
        int [][] maxArr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 0; j < 3; j++) {
                if (st.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            // 위에서 접근가능한 곳을 Math로 구하고 arr[i][?]를 더해주면 간단하게 출력된다. 0 은 [0,1] ,1은 [0,1,2] 2는[1,2] 인덱스 접근가능
            minArr[i][0] = Math.min(minArr[i - 1][0], minArr[i - 1][1]) + arr[i][0];
            minArr[i][1] = Math.min( Math.min(minArr[i - 1][0], minArr[i - 1][1]),minArr[i - 1][2] )  + arr[i][1];
            minArr[i][2] = Math.min(minArr[i - 1][1], minArr[i - 1][2]) + arr[i][2];

            maxArr[i][0] = Math.max(maxArr[i - 1][0], maxArr[i - 1][1]) + arr[i][0];
            maxArr[i][1] = Math.max( Math.max(maxArr[i - 1][0], maxArr[i - 1][1]),maxArr[i - 1][2] )  + arr[i][1];
            maxArr[i][2] = Math.max(maxArr[i - 1][1], maxArr[i - 1][2]) + arr[i][2];
        }

        int max = Arrays.stream(maxArr[n]).max().getAsInt();
        int min =Arrays.stream(minArr[n]).min().getAsInt();
        System.out.println(max+" "+min);


    }

}