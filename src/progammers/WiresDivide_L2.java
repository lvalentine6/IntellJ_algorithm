package progammers;

import java.util.LinkedList;
import java.util.Queue;

public class WiresDivide_L2 {
    static int[][] arr;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer = Integer.MAX_VALUE;

        // 인접 행렬 만들기
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 선 하나씩 끊으면서 bfs 탐색
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            // 선 끊기
            arr[left][right] = 0;
            arr[right][left] = 0;

            // bfs
            answer = Math.min(answer, bfs(left, n));

            // 끊었던 선 복구
            arr[left][right] = 1;
            arr[right][left] = 1;
        }

        System.out.println(answer);

    }

    // bfs 메서드
    static int bfs(int left, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(left);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        // cnt와 n - cnt는 각각 연결된 전력망
        return Math.abs(cnt - (n - cnt));
    }
}
