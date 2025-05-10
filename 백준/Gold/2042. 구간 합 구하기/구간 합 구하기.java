import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int treeHeight, treeSize, leftNodeStartIndex;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 수의 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간합을 구하는 횟수

        // 트리 높이, 크기, leaf 시작 인덱스 계산
        treeHeight = 0;
        int length = N;
        // 세그머트 트리를 배열로 나타내기위한 2의 k 승이 > N 보다 커야하는 조건
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        treeSize = (int) Math.pow(2, treeHeight + 1);   // 전체 트리 노드 개수
        leftNodeStartIndex = treeSize / 2; // 리프 노드 시작 인덱스
        tree = new long[treeSize];

        // leaf 영역에만 값 입력
        for (int i = leftNodeStartIndex; i < leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        // (여기까지 세그먼트 트리 배열의 선언과 리프노트를 채운거임)
        

        // 부모 노드 채우기 -> setTree-1 인자는 세그먼트 트리 배열의 오른쪽에서부터 구간합을 채워 넣기 위한 시작점
        setTree(treeSize - 1);

        StringBuilder sb = new StringBuilder();

        //  M + K 번 수행
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) { // 값 변경
                int index = Integer.parseInt(st.nextToken());
                long newValue = Long.parseLong(st.nextToken());
                int treeIndex = leftNodeStartIndex + index - 1; // 입력값 → tree 배열 index 변환
                // 부모 노드로만 이동해가며 업데이트 (log n)
                changeVal(treeIndex, newValue);

            } else if (command == 2) { // 구간 합
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                int leftIndex = leftNodeStartIndex + left - 1;
                int rightIndex = leftNodeStartIndex + right - 1;
                sb.append(getSum(leftIndex, rightIndex)).append("\n");
            }
        }

        System.out.print(sb);
    }

    //  setTree() 함수 (부모로 거슬러 올라가며 sum)
    static void setTree(int i) {
        // 루트 노드까지 가겠다는 뜻
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

    // 업데이트
    static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }
    // 구간 합 구하기
    static long getSum(int s, int e) {
        long partSum = 0;
        // 시작점이 종료점과와 교차될 떄까지
        while (s <= e) {
            if (s % 2 == 1) { // 왼쪽이 오른쪽 자식인 경우
                partSum += tree[s];
                s++;
            }
            if (e % 2 == 0) { // 오른쪽이 왼쪽 자식인 경우
                partSum += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }
}
