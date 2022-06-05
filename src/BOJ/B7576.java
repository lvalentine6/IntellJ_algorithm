package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B7576 {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        // 1. 입력값 배열에 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 배열에서 익은 토마토(1)을 발견하면 List에 배열 형태로 추가
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    list.add(new int[] {i, j});
                }
            }
        }

        // bfs를 실행하고 반환값중 최솟값 출력
        answer = Math.min(bfs(list),answer);
        System.out.println(answer);
    }
    static int bfs(List<int[]> list) {
        //
        int[][] arr2 = arr.clone();
        int max = 0;
        boolean[][] visited2 = visited.clone();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] listTemp = list.get(i);
            queue.add(listTemp);
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nowX = temp[0];
            int nowY = temp[1];
            visited2[nowX][nowY] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                if (visited2[nextX][nextY] || arr2[nextX][nextY] == -1 || arr2[nextX][nextY] == 1) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited2[nextX][nextY] = true;
                arr2[nextX][nextY] = arr2[nowX][nowY] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr2[i][j] == 0) {
                    return -1;
                } else {
                    max = Math.max(arr2[i][j], max);
                }
            }
        }
        return max - 1;
    }
}
