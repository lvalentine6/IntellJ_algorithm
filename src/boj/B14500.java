package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
    static int n, m, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ax = {{0, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}};
    static int[][] ay = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표로 만들수 있는 테트로미노 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                search(i, j, 0, arr[i][j]);
                visited[i][j] = false;
                another(i, j);
            }
        }
        System.out.println(max);
    }

    static void search(int x, int y, int depth, int sum) {
        if (depth == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                search(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void another(int x, int y) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + ax[i][j];
                int ny = y + ay[i][j];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    check = true;
                    continue;
                }

                sum += arr[nx][ny];
            }
            if (!check) {
                max = Math.max(sum, max);
            }
        }
    }
}
