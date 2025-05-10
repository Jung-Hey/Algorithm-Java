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
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 트리 높이, 크기, leaf 시작 인덱스 계산
        treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        treeSize = (int) Math.pow(2, treeHeight + 1);   // 전체 트리 노드 개수
        leftNodeStartIndex = treeSize / 2;              // 리프 노드 시작 인덱스
        tree = new long[treeSize];

        // leaf 영역에만 값 입력
        for (int i = leftNodeStartIndex; i < leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 부모 노드 채우
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

                long diff = newValue - tree[treeIndex];
                tree[treeIndex] = newValue;

                // 부모로만 올라가며 업데이트
                while (treeIndex > 1) {
                    treeIndex /= 2;
                    tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
                }
            } else if (command == 2) { // 구간 합
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                //  구간을 leaf 인덱스로 변환
                int leftIndex = leftNodeStartIndex + left - 1;
                int rightIndex = leftNodeStartIndex + right - 1;
                long sum = 0;

                // 구간합 방식
                while (leftIndex <= rightIndex) {
                    if (leftIndex % 2 == 1) sum += tree[leftIndex++];  // 왼쪽이 오른쪽 자식일 경우
                    if (rightIndex % 2 == 0) sum += tree[rightIndex--]; // 오른쪽이 왼쪽 자식일 경우
                    leftIndex /= 2;
                    rightIndex /= 2;
                }

                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);
    }

    //  setTree() 함수 (부모로 거슬러 올라가며 sum)
    static void setTree(int i) {
        while (i > 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
