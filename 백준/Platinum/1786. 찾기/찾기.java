import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		int n = text.length(); // 전체 문자열의 길이
		int m = pattern.length(); // 패턴 문자열의 길이
		
		/**
		 * pi = 부분 일치 문자열 테이블
		 * pi[i] :  0 ~ i  부분 중에서, 접두사와 접미사가 일치하는 최대 길이
		 */
		int [] pi = new int[m];
		
		// 부분 일치 테이블 만들기
		// j는 접미사 i는 접두사
		for (int j = 1, i = 0; j < m; j++) {
			// 하나 이상 부분일치를 찾은 상태에서 다음 문자가 일치하지 않을때
			while(i > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				i = pi[i-1]; // 지금까지 일치한 부분 중 다시 시도할 수 있는 길이
			}
			// 일치
			if(pattern.charAt(j) == pattern.charAt(i)) {
				pi[j] = ++i;
			}
			else { // 불일치
				pi[j] = 0;
			}
		}
		//System.out.println(Arrays.toString(pi));
		
		
		// 패턴과 일차하는 문자 찾기
		int count = 0; // 일치하는 패턴의 등장 횟수
		List<Integer> list = new ArrayList<>();
		
		// i는 텍스트 j는 패턴을 가르키는 인덱스 변수 
		for (int i = 0, j = 0; i < n; i++) {
			// 패턴과 본문이 하나 이상 일치하는 것을 찾은 상태에서 틀리면
			while( j > 0 && text.charAt(i) != pattern.charAt(j) ) {
				j = pi[j-1];
			}
			// 일치
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == m-1) { // 패턴과 전부일치하면 (찾았으면)
					++count;
					list.add(i-j);
					j = pi[m-1]; // 다 찾고난 후에도 부분일치테이블 정보를 이용해 쉬프트 
				}
				else { // 일부 일치중인거면
					++j;
				}
			}
		
		}
		System.out.println(count);
		if(count > 0) {
			for(int num : list) {
				System.out.print( (num+1) +" ");
			}
		}

	}

}

//ababababcababaca
//abacabab