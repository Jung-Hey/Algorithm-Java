import java.io.BufferedReader;

/**
 * B구획의 빌딩 최고 높이 구하기
 */
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildingTest {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] dx = {-1, -1, 0 , 1, 1, 1, 0, -1};
        int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int tc = Integer.parseInt(br.readLine()); // 1
        int t=0;

        while (t++ <  tc){
            int n  = Integer.parseInt(br.readLine()); // 3
            int answer = 0;
            char [][] arr = new char[n][n];
            // input
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().replace(" ", "").toCharArray();
            }
            // solve
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 빌딩을 지을 수 있는 구획이라면
                    if(arr[i][j] == 'B'){
                        boolean isGarden = false;
                        for (int k = 0; k < 8; k++) {
                            int nx = dx[k] + i;
                            int ny = dy[k] + j;
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(arr[nx][ny] == 'G') isGarden = true;
                        }
                        // 빌딩 있으면 2층 높이
                        if(isGarden) answer = Math.max(answer, 2);
                            // 없으면 범위 내 가로세로의 B의 개수가 높이
                        else{
                            int tmp = 0;
                            for (int k = 0; k < n; k++) {
                                if(arr[i][k] == 'B') tmp++;
                                if(arr[k][j] == 'B') tmp++;
                                answer = Math.max(answer, tmp-1);
                            }
                        }
                    }
                }

            }
            sb.append("#"+t+" ").append(answer+"\n");
        }
        System.out.println(sb);
        br.close();

    }
}
