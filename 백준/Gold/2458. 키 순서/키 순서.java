import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> reverse;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer=0;
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            reverse.get(b).add(a);
        }
        for (int i = 1; i <= n ; i++) {
            solve(i,n);
        }
        System.out.println(answer);



    }

    private static void solve(int vex, int n) {
        int count=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(vex);
        boolean[] isVisited = new boolean[n+1];

        isVisited[vex] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            for (int nv : graph.get(now)){
                if(!isVisited[nv]){
                    isVisited[nv] = true;
                    count++;
                    q.offer(nv);
                }
            }
        }

        q.offer(vex);
        while (!q.isEmpty()){
            int now = q.poll();
            for (int nv : reverse.get(now)){
                if(!isVisited[nv]){
                    isVisited[nv] = true;
                    count++;
                    q.offer(nv);
                }
            }
        }


        if(count == n-1) answer++;



    }
}