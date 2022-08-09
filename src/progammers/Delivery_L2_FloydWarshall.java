package progammers;

public class Delivery_L2_FloydWarshall {
    public static void main(String[] args) {
        int N = 6;
        int K = 4;
//        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int answer = 0;

        // 플로이드 와셜 알고리즘을 위한 2차원 배열
        int[][] arr = new int[N][N];

        // 최댓값으로 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 자신의 정점으로 배달은 0으로 초기화
                if(i == j) {
                    continue;
                }
                arr[i][j] = 500001;
            }
        }

        // 배열 인덱스를 0부터 하기위해 -1 뺴주고 인접 행렬 만들기
        for (int i = 0; i < road.length; i++) {
            // 새로 입력되는 거리가 더 크면 무시
            if(arr[road[i][0] - 1][road[i][1] - 1] < road[i][2]) {
                continue;
            }
            arr[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            arr[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        // 플로이드 와샬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // ij를 바로 가는것과 K를 거쳐서 가는것중 거쳐서 가는게 더 빠를 경우
                    if(arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            if(arr[0][i] <= K) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
