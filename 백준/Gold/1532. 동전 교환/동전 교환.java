import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * 11860 kb
 * 72  ms
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int G = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		G -= Integer.parseInt(st.nextToken()); // 부족한 금화 
		S -= Integer.parseInt(st.nextToken());
		B -= Integer.parseInt(st.nextToken());
        
        int changeCnt = 0;
        while( true ) {
        	// 금화 부족
			if( G < 0) {	
				//1순위 남는 은으로 금 채우기
				if(S>=11) {
					G++;
					S-=11;
					changeCnt++;
					continue;
				}
				// 2순위로 남는 동을 은으로 만들기
				if(B>=11) {	
					S++;
					B-= 11;
					changeCnt++;
					continue;
				}
				//실패
				System.out.println(-1);
				return;
			}
			// 은화 부족
        	else if(S < 0) {
        		// 1순위는 금이 여유있어서 은화를 만들 수 있으면 만듦
        		if(G >= 1) { 
        			G--;
        			S+=9;
        			changeCnt++;
        			continue;
        		}
        		// 2순위는 동화로 은화 만들기
        		if(B >= 11) {
        			B -= 11;
        			S++;
        			changeCnt++;
        			continue;
        		}
        		//실패
				System.out.println(-1);
				return;
        	}
			// 동화 부족
        	else if(B < 0) {
        		// 1순위는 은화 여유있어서 은화로 동화 만들기
        		if(S >= 1) {
        			S--;
        			B+=9;
        			changeCnt++;
        			continue;
        		}
        		
        		// 2순위는 금이 여유있어서 은화를 만들 수 있으면 만듦
        		if(G >= 1) { 
        			G--;
        			S+=9;
        			changeCnt++;
        			continue;
        		}
        		System.out.println(-1);
				return;
        	}
			
			// 정상적으로 모두 교환을 만족
			System.out.println(changeCnt);
			return;
        }
        
		
		
    }
}
