package progammers;

import java.util.*;

// 1. 인접행렬 만들기
// 2. bfs 탐색 (실패)
// 3. 1번 음식점에서 1번 마을로 배달 가능
// 4. 플로이드 와샬(모든 정점끼리 최단거리) vs 다익스트라(하나의 정점에서 다른 정점들의 최단거리)
public class Delivery_L2_Dijkstra {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) {
        int n = 6;
        int k = 4;
//        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};

        cnt = 0;
        arr = new int[n + 1][n + 1];

        // 인접 행렬 초기화
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = 500001;
            }
        }

        // 인접행렬 거리값 삽입
        for (int i = 0; i < road.length; i++) {
            if(arr[road[i][0]][road[i][1]] > road[i][2]) {
                arr[road[i][0]][road[i][1]] = road[i][2];
                arr[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        // 거리, 방문 배열 만들기
        dist = new int[n + 1];
        // 최댓값으로 초기화
        for (int i = 2; i < n + 1; i++) {
            dist[i] = 500001;
        }
        visited = new boolean[n + 1];
        // 첫번째 마을 체크
        visited[1] = true;

        // 다익스트라 메서드 호출
        dijkstra(n, k);

        int answer = cnt;
        System.out.println(answer);
    }

    // 다익스트라 메서드
    static void dijkstra(int n, int k) {
        // 0 ~ n-1 or 1 ~ n 까지 반복
        for (int i = 1; i < n; i++) {
            int min = 500001;
            int idx = 1;

            // 가장 작은 거리애 있는 인덱스값 찾기
            for (int j = 2; j <= n; j++) {
                if(!visited[j] && min > dist[j]) {
                    idx = j;
                    min = dist[j];
                }
            }

            // 방문 체크
            visited[idx] = true;

            // 돌아가는 루트가 더 빠른지 탐색
            for (int j = 2; j <= n ; j++) {
                if(dist[j] > dist[idx] + arr[idx][j]) {
                    dist[j] = dist[idx] + arr[idx][j];
                }
            }
        }

        // k 이하의 값 카운트
        for (int i = 1; i <= n ; i++) {
            if(dist[i] <= k) {
                cnt++;
            }
        }
    }
}
