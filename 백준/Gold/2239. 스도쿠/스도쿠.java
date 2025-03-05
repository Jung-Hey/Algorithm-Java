import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[][] arr;
	static List<int[]> list;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new int[9][9];
		// [9] : 0~9 스도쿠 자리 [2] : 0은 행 1은 열 [9] : ?스도쿠 자리의 행or열에 출현한 번호 
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < 9; j++) {
				if(arr[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		// solve
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		// solve
		System.out.println(sb);
		
	}

	

	private static void dfs(int l) {
		//print();
		// 스도쿠 완성
		if(l == list.size()) {
			//System.out.println("end");
			flag = true;
		}
		else {
			int [] zero = list.get(l);
			for (int i = 1; i <= 9; i++) {
				if(isValid(zero, i)) {
					arr[zero[0]][zero[1]] = i;
					dfs(l+1);
					if(flag) return;
				}
				
			}
			arr[zero[0]][zero[1]] = 0;
		}
		
	}

	
	


	private static void print() {
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}



	private static boolean isValid(int[] zero, int value) {
		int x = zero[0], y = zero[1];
		
		// 행 검사
		for (int j = 0; j < 9; j++) {
			if(arr[x][j] == value) return false; 
		}
		// 열 검사
		for (int j = 0; j < 9; j++) {
			if(arr[j][y] == value) return false; 
		}
		// 3x3 검사 
		int tx = (x / 3) * 3;
		int ty = (y / 3) * 3;
		for (int i=tx; i<tx+3; i++) {
			for (int j=ty; j<ty+3; j++) {
				if (arr[i][j] == value) return false;
			}
		}
				
			

		return true;
	}

	


}