package progammers;

import java.util.*;

// 1. 인접행렬 만들기
// 2. bfs 탐색 (실패)
// 3. 1번 음식점에서 1번 마을로 배달 가능
// 4. 플로이드 와샬(모든 정점끼리 최단거리) vs 다익스트라(하나의 정점에서 다른 정점들의 최단거리)
public class Delivery_L2 {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};

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
            arr[road[i][0]][road[i][1]] = road[i][2];
            arr[road[i][1]][road[i][0]] = road[i][2];
        }

        dist = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            dist[i] = 500001;
        }
        visited = new boolean[n + 1];
        visited[1] = true;

        System.out.println(Arrays.toString(dist));

        dijkstra(n, k);

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(dist));
        System.out.println(cnt);
    }

    static void dijkstra(int n, int k) {
        for (int i = 1; i <= n - 1; i++) {
            int min = 500001;
            int idx = 1;

            for (int j = 2; j <= n; j++) {
                if(!visited[j] && min > dist[j]) {
                    idx = j;
                    min = dist[j];
                }
            }

            visited[idx] = true;

            for (int j = 2; j <= n ; j++) {
                if(dist[j] > dist[idx] + arr[idx][j]) {
                    dist[j] = dist[idx] + arr[idx][j];
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            if(dist[i] <= k) {
                cnt++;
            }
        }
    }
}
