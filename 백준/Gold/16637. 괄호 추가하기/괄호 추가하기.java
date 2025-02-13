
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Character> opList;
	public static List<Integer> numList;
	public static long answer;
	
	public static long calc(long a, long b, char op) {
//	    return switch (op) {
//	        case '+' -> a + b;
//	        case '-' -> a - b;
//	        case '*' -> a * b;
//	        default -> 0;
//	    };
	    switch (op) {
	        case '+' :
	        	return a + b;
	        case '-' :
	        	return a - b;
	        case '*' :
	        	return a * b;
	        default : 
	        	return 1L;
	    }
	}
	
	public static void dfs(int level, long sum) {
		if(level >= opList.size()) {
			answer = Math.max(answer,sum);
			return;
		}
		else {
			// 괄호 없이 계산 
			long now = calc(sum, numList.get(level+1), opList.get(level));
			dfs(level+1, now);
			
			// 괄호 있게 계산 
			// 다음 식 
			if(level+1 < opList.size()) {
				long next = calc(numList.get(level+1), numList.get(level+2),opList.get(level+1) );
				long res = calc(sum, next, opList.get(level));
				dfs(level+2, res); // 다음 연산자를 계산했기 때문에  level+2
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		opList = new ArrayList<>();
		numList = new ArrayList<>();
		answer = Integer.MIN_VALUE;
		int n = Integer.parseInt(br.readLine()); 
		String exp = br.readLine(); // 식 입력
		// 연산자와 피연산자 분리해 개별 리스트에 저장 
		for(char c : exp.toCharArray()) {
			if(Character.isDigit(c)) {
				numList.add((int)c-'0');
			}
			else opList.add(c);
		}
		dfs(0, (long)numList.get(0));
		System.out.println(answer);
    }
	
}
