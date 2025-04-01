import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 물품의 수
		int limit = Integer.parseInt(st.nextToken()); // 최대 수용 가능한 무게
		int [] value = new int[n];
		int [] weight = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		// solve
		int [] dy = new int[limit+1]; // x 무게만큼 가능한 최대 가치
		for (int i = 0; i < n; i++) {
			for (int j = limit; j >= weight[i]; j--) {
				dy[j] = Math.max(dy[j], dy[j-weight[i]] + value[i]);
			}
		}
		// output
		System.out.println(dy[limit]);

    }
}
