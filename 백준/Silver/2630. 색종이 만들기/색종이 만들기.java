
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] arr;
	static int whiteCnt, greenCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr= new int[n][n];
		whiteCnt = 0 ; greenCnt=0;
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		//sovle
		divideArea(0,0,n);
		System.out.println(whiteCnt);
		System.out.println(greenCnt);
		
	}
	
	// 1이 green 0이 white 
	private static void divideArea(int x, int y, int size) {
		if(size==1) {
			int color = arr[x][y];
			if(color == 1) greenCnt ++;
			else whiteCnt ++;
		}
		else {
			// 검사
			if(checkColor(x,y,size)) {
				int color = arr[x][y];
				if(color == 1) greenCnt ++;
				else whiteCnt ++;
			}
			else {
				// 실패 시 4등분 해야함 
				int halfSize = size/2;
				divideArea(x,y,halfSize);
				divideArea(x+halfSize,y,halfSize);
				divideArea(x,y+halfSize,halfSize);
				divideArea(x+halfSize,y+halfSize,halfSize);
			}
			
		}

		
	}
	
	private static boolean checkColor(int x, int y, int size) {
		int color = arr[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(arr[i][j] != color) return false;
			}
		}
		return true;
	}

	

}
