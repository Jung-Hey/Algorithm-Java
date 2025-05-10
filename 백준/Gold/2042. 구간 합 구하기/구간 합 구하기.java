import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;        // 영상에서는 대문자 사용을 좋아함 (N: 원소 개수, M: 변경 횟수, K: 구간합 횟수)
	static long[] arr, tree;   // arr: 원본 배열, tree: 세그먼트 트리 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 트리 높이, 크기, leaf 시작 인덱스 계산
		int treeHeight = 0;
		int length = N;
		while (length != 0) {
			length /= 2;
			treeHeight++;
		}

		int treeSize = (int) Math.pow(2, treeHeight + 1);   // 전체 트리 노드 개수
		int leftNodeStartIndex = treeSize / 2;              // 리프 노드 시작 인덱스

		arr = new long[N + 1];
		tree = new long[treeSize];

		// 입력 받기
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		// 세그먼트 트리 초기화
		init(1, N, 1);

		StringBuilder sb = new StringBuilder();

		// 총 M + K 번 쿼리 실행
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) { // 값 변경
				int index = Integer.parseInt(st.nextToken());
				long newValue = Long.parseLong(st.nextToken());
				long diff = newValue - arr[index];
				arr[index] = newValue;
				update(1, N, 1, index, diff);
			} else if (command == 2) { // 구간 합
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(query(1, N, 1, left, right)).append("\n");
			}
		}

		System.out.print(sb);
	}

	// 트리 초기화 ( left/right + node)
	static long init(int left, int right, int node) {
		if (left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left + right) / 2;
		return tree[node] = init(left, mid, node * 2) + init(mid + 1, right, node * 2 + 1);
	}

	// 트리 업데이트
	static void update(int left, int right, int node, int index, long diff) {
		if (index < left || index > right) return;

		tree[node] += diff;

		if (left != right) {
			int mid = (left + right) / 2;
			update(left, mid, node * 2, index, diff);
			update(mid + 1, right, node * 2 + 1, index, diff);
		}
	}

	// 간합 쿼리
	static long query(int left, int right, int node, int queryLeft, int queryRight) {
		// 전혀 겹치지 않는 경우
		if (queryRight < left || right < queryLeft) return 0;

		// 완전히 포함되는 경우
		if (queryLeft <= left && right <= queryRight) return tree[node];

		// 일부만 겹치는 경우
		int mid = (left + right) / 2;
		return query(left, mid, node * 2, queryLeft, queryRight)
				+ query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
	}
}
