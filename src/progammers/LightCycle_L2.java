package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LightCycle_L2 {
    static int x, y;
    // 왼쪽 -> 아래 -> 오른쪽 -> 위 순환
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][] visited;

    public static void main(String[] args) {
        String[] grid = {"SL", "LR"};

        // 배열의 가로, 세로 크기
        x = grid.length;
        y = grid[0].length();

        // 경로를 담기 위한 list
        List<Integer> list = new ArrayList<>();

        // 탐색을 위한 배열
        visited = new boolean[x][y][4];

        // 탐색
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < 4; k++) {
                    if(!visited[i][j][k])
                    list.add(cycle(grid, i, j, k));
                }
            }
        }

        // list 정렬
        Collections.sort(list);
        int[] answer = list.stream().mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(answer));
    }

    static int cycle(String[] grid, int i, int j, int k) {
        // 경로 카운트
        int cnt = 0;

        // 처음 위치로 되올아오면 탐색 종료
        while (!visited[i][j][k]) {
            // 임의의 위치에서 빛 쏘고 방문 체크
            visited[i][j][k] = true;
            cnt++;

            // 왼쪽 0, 아래 1, 왼쪽 2, 위 3
            if (grid[i].charAt(j) == 'L') {
                k = k == 0 ? 3 : k - 1;
            } else if (grid[i].charAt(j) == 'R') {
                k = k == 3 ? 0 : k + 1;
            }

            // 탐색 범위를 벗어나면 좌표 재지정
            i = (i + dx[k] + x) % x;
            j = (j + dy[k] + y) % y;
        }
        return cnt;
    }
}
