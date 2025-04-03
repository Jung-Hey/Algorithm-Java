import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 28,416 kb
 * 99 ms
 */
class Stair{
	int x;
	int y;
	int len;
	public Stair(int x, int y, int len) {
		super();
		this.x = x;
		this.y = y;
		this.len = len;
	}
	@Override
	public String toString() {
		
		return "x : "+x + " y : "+y + " len : "+len;
	}
	
}
class Person{
	int x;
	int y;
	int dis1;
	int dis2;
	public Person(int x, int y, int dis1, int dis2) {
		super();
		this.x = x;
		this.y = y;
		this.dis1 = dis1;
		this.dis2 = dis2;
	}
}

public class Solution {
	static StringBuilder sb;
	static boolean[] ch;
	static int n, answer;
	static List<Person> personList;
	static Stair s1, s2;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt(br.readLine()), t=0;
		sb = new StringBuilder();
		while(t++<tc) {
			sb.append("#").append(t).append(" ");
			answer = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			List<Stair> stairList = new ArrayList<>();
			personList = new ArrayList<>();
			// input
			n = Integer.parseInt(st.nextToken());
			
			int [][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				// 입력에서 계단 찾기
				if(stairList.size() != 2) {
					for (int j = 0; j < n; j++) {
						int value = arr[i][j];
						// 계단
						if(value > 1) {
							stairList.add(new Stair(i,j,value));
						}
					}
				}
			}
			s1 = stairList.get(0);
			s2 = stairList.get(1);
			// 각 사람당 두 계단입구와의 거리를 저장
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i][j] == 1) {
						int dis1 = Math.abs(i-s1.x) + Math.abs(j-s1.y);
						int dis2 = Math.abs(i-s2.x) + Math.abs(j-s2.y);
						personList.add(new Person(i, j, dis1, dis2));
					}
				}
			}
			ch = new boolean[personList.size()];
			// solve
			getSubSet(0);	
			
			sb.append(answer).append("\n");
		}
		//output
		System.out.println(sb);	
	}

	// 1번 계단에 갈 사람들을 구한다
	private static void getSubSet(int l) {
		if(l == personList.size()) {
			solve();
		}
		else {
			ch[l] = true;
			getSubSet(l+1);
			ch[l] = false;
			getSubSet(l+1);
		}
	}

	// 해당 부분집합으로 계단을 내려가는 시뮬레이션 후 최소 시간 갱신
	private static void solve() {
		int time = 1;
		int count = 0;
		int personCount = personList.size();
		// 계단 입구에 도착한 사람 방문 체크
		boolean [] isVisted = new boolean[personCount];
		// 입구에서 대기하는 큐
		Queue<Integer> wait1Q = new ArrayDeque<>();
		// 계단을 내려가는 큐
		Queue<Integer> stair1Q = new ArrayDeque<>();
		Queue<Integer> wait2Q = new ArrayDeque<>();
		// 계단을 내려가는 큐
		Queue<Integer> stair2Q = new ArrayDeque<>();
		// 모든 사람이 계단을 내려올때까지
		while( count < personCount ) {
			// 계단 입구로 가는 과정
			for (int i = 0; i < personCount; i++) {
				if(isVisted[i]) continue;
				Person p = personList.get(i);
				// i번 사람이 1번 계단입구로 가는 집단이라면
				if(ch[i]) {
					if(p.dis1 == time) {
						isVisted[i] = true;
						// 대기큐에 넣음 몇번사람인지는 알 필요 없으니 계단의 길이 너자
						wait1Q.offer(s1.len);
					}
				}
				// i번 사람이 2번 계단입구로 가는 집단이라면
				else {
					if(p.dis2 == time) {
						isVisted[i] = true;
						// 대기큐에 넣음 몇번사람인지는 알 필요 없으니 계단의 길이 너자
						wait2Q.offer(s2.len);
					}
				}
			}
			// 1번 계단 내려가기
			int len = stair1Q.size();
			for (int i = 0; i < len; i++) {
				int t = stair1Q.poll();
				if(--t > 0) stair1Q.offer(t); // 계단 내려가는 중
				else {
					count++; // 다 내려간 경우
				}
			}
			// 2번 계단 내려가기
			len = stair2Q.size();
			for (int i = 0; i < len; i++) {
				int t = stair2Q.poll();
				if(--t > 0) stair2Q.offer(t); // 계단 내려가는 중
				else {
					count++; // 다 내려간 경우
				}
			}
			
			// 계단 입구까지 도착하면(waitQ에 존재) 계단 내려가는 인원으로 추가
			while(stair1Q.size() < 3 && !wait1Q.isEmpty()) {
				stair1Q.offer(wait1Q.poll());
			}
			while(stair2Q.size() < 3 && !wait2Q.isEmpty()) {
				stair2Q.offer(wait2Q.poll());
			}
			time++;
		}
		// 최소값 갱신
		answer = Math.min(answer, time);
	}

}
