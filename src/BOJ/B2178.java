package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    static int n, m, cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        bfs(1, 1);
        System.out.println(arr[n][m]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                // 탐색 범위를 벗어나면
                if (nx < 0 || ny < 0 || nx > n || ny > m) {
                    continue;
                }
                // 이미 탐색한 노드거나 0인 노드라면
                if(visit[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                // 현재 노드 값에 1을 더한다
                arr[nx][ny] = arr[now[0]][now[1]] + 1;
            }
        }
    }
}
