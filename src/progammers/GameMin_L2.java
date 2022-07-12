package progammers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameMin_L2 {
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) {
//        maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int answer = 0;

        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        answer = bfs(0, 0, maps);

        System.out.println(answer);
        System.out.println(Arrays.deepToString(maps));

    }

    static int bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[temp[0]][temp[1]] + 1;
                }

            }
        }
        if(visited[n-1][m-1]) {
            return maps[n-1][m-1];
        } else {
            return -1;
        }
    }
}
