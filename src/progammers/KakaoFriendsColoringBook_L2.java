package progammers;

import java.util.Arrays;

public class KakaoFriendsColoringBook_L2 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int m = 6;
    static int n = 4;
    static int cnt = 1;
    //    static int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
//            {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    static int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

    public static void main(String[] args) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 0이 아니고 방문한적이 없다면 dfs 실행
                if (picture[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    cnt = 1;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(Arrays.toString(answer));
    }

    static void dfs(int x, int y, int[][] picture) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            // 범위 내에 있다면
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                // 현재 위치와 이동할 위차가 같고 방문한적이 없다면
                if (picture[x][y] == picture[nextX][nextY] && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, picture);
                    cnt++;
                }
            }
        }
    }
}
