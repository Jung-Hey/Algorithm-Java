import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,d;
    static int[][] arr;
    static int enemyCnt, answer, tmp, killCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[n+1][m]; // +1은 마지막 성의 궁수들 칸
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int e : arr[i]){
                if(e==1) enemyCnt++;
            }
        }
        //
        // 3명의 궁수 조합
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                for (int k = j+1; k < m; k++) {
                    if(i==j|| j==k) continue;
                    solve(i,j,k);
                }
            }
        }
        System.out.println(answer);

    }

    private static void solve(int a1, int a2, int a3) {
        tmp = 0; // 제외된 적의 수
        killCnt = 0;// 궁수로 잡은 적의 수
        int[][] copy = copy();
        // 성에 궁수 배치
        copy[n][a1] = 2;
        copy[n][a2] = 2;
        copy[n][a3] = 2;
        // 게임 시작
        while (tmp < enemyCnt){
            // 궁수
        	for (int i = 0; i < m; i++) {
				if(copy[n][i] == 2) {
					if(bfs(n,i,copy)) {
						tmp++;
						killCnt++;;
					};
					
				}
			}
        	//print(copy);
            // 적 이동
        	tmp = moveEnemy(tmp, copy);
        	// 확인
        	//print(copy);
        }
        answer = Math.max(answer, killCnt);
        
    }

    private static int moveEnemy(int tmp, int[][] copy) {
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if(copy[i][j]==1) {
					// 제외되는 경우 
					if(i+1 == n) {
						//System.out.print("!");
						copy[i][j]=0;
						tmp++; 
					}
					else {
						//System.out.print("@");

						copy[i][j] = 0;
						copy[i+1][j] = 1;
					}
				}
				else if(copy[i][j]==-1) {
					copy[i][j] = 0;
				}
			}
		}
		
		return tmp;
		
	}

	private static void print(int[][] copy) {
    	System.out.println("tmp = "+tmp +" killCnt = "+killCnt);
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(copy[i]));
		}
		
	}

	private static boolean bfs(int x, int y, int[][] copy) {
		int[] dx = {0,-1,0};
		int[] dy = {-1,0,1};
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y,0}); //궁수
		boolean [][] dis = new boolean[n+1][m];
		dis[x][y] = true;
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			for(int i=0; i<3; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int move = now[2];
				if(nx==n || nx < 0 || ny < 0 || ny >= m) continue;
				if(dis[nx][ny])continue;
				if(move>=d) continue;
				if(copy[nx][ny] == 0) {
					q.offer(new int[] {nx,ny,move+1});
					dis[nx][ny] = true;
			
				}
				if(copy[nx][ny] == 1 || copy[nx][ny] == -1) {
					if(copy[nx][ny] == 1) {
						copy[nx][ny] = -1;
						return true; // 적 찾음
					}
					else return false; // 이미 죽인 적 
					
				}
			}
			
		}
		return false;
	}

	public static int[][] copy(){
        int [][] copy = new int[n+1][m];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }


}
