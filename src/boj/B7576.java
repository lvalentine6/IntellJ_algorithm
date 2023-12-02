package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        // 입력값 배열에 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 배열에서 익은 토마토(1)을 발견하면 List에 배열 형태로 추가
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        // bfs 실행후 출력
        System.out.println(bfs(list));
    }

    static int bfs(List<int[]> list) {
        // 배열에서 탐색한 최댓값을 반환하기 위한 변수
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        // List에서 배열을 뽑아 queue에 삽입
        // queue.addAll(list); 로 바꿀수 있음
        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }
        // bfs 실행
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nowX = temp[0];
            int nowY = temp[1];
            visited[nowX][nowY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                // 탐색 범위를 벗어나면
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                // 방문한 노드거나 값이 -1, 0 이면
                if (visited[nextX][nextY] || arr[nextX][nextY] == -1 || arr[nextX][nextY] == 1) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                arr[nextX][nextY] = arr[nowX][nowY] + 1;
            }
        }
        // 완성된 배열을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 배열 값중 0이 있다면
                if (arr[i][j] == 0) {
                    return -1;
                } else {
                    // 탐색값중 가장 큰 값을 max에 배정
                    max = Math.max(arr[i][j], max);
                }
            }
        }
        // 하루를 빼줘야 함
        return max - 1;
    }
}
