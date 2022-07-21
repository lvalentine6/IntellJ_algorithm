package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 벽을 세우는 알고리즘 -> 모르겠는데 이거 재귀로 완탐?
// 바이러스를 퍼트리는 알고리즘 (BFS)
// 0을 세는 알고리즘 (탐색)
public class B14502 {
    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, 1, 0, 0,};
    static boolean[][] virusVisited;
    static List<int[]> list;
    static List<Integer> cntList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        virusVisited = new boolean[n][m];
        list = new ArrayList<>();
        cntList = new ArrayList<>();

        // 입력값 배열 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }

        wall(arr, visited, 0);

//        System.out.println(cntList);
        int max = Collections.max(cntList);
        System.out.println(max);

    }

    static void wall(int[][] array, boolean[][] visit, int depth) {
        if (depth == 3) {
            int[][] arrayTemp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arrayTemp[i][j] = array[i][j];
                }
            }
            virus(array);
            array = arrayTemp;
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    array[i][j] = 1;
                    wall(array, visit, depth + 1);
                    array[i][j] = 0;
                    visit[i][j] = false;
                }
            }
        }
    }

    static void virus(int[][] array) {
        for (int[] temp : list) {
            Queue<int[]> queue = new LinkedList();
            queue.add(temp);

            while (!queue.isEmpty()) {
                int[] qTemp = queue.poll();
                virusVisited[temp[0]][temp[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = qTemp[0] + dx[i];
                    int ny = qTemp[1] + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }

                    if(array[nx][ny] == 0 && !virusVisited[nx][ny]) {
                        virusVisited[nx][ny] = true;
                        array[nx][ny] = 2;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(virusVisited));
        cal(array);
        virusVisited = new boolean[n][m];
    }

    static void cal(int[][] array) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(array[i][j] == 0) {
                    cnt++;
                }
            }
        }
        cntList.add(cnt);
    }
}

