package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 벽을 세우는 알고리즘 -> 모르겠는데 재귀로 완탐하자
// 바이러스를 퍼트리는 알고리즘 (BFS)
// 0을 세는 알고리즘 (탐색)

public class B14502 {
    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
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

        // 첫 메서드 호출
        wall(arr, visited, 0);

        // 리스트에서 가장 큰 수 뽑기
        int max = Collections.max(cntList);
        System.out.println(max);

    }

    // 완전탐색으로 벽 쌓는 메서드
    static void wall(int[][] array, boolean[][] visit, int depth) {
        // 벽 3개를 세웠다면
        if (depth == 3) {
            // array를 복사해서 다음 메서드로 넘겨줌 (clone으로는 깊은 복사 안됨)
            int[][] arrayTemp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arrayTemp[i][j] = array[i][j];
                }
            }

            // 바이러스 메서드 호출
            virus(arrayTemp);
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

    // BFS를 통해 바이러스 퍼트리는 메서드
    static void virus(int[][] array) {
        // 바이러스가 포함된 좌표 불러오기
        for (int[] temp : list) {
            // BFS
            Queue<int[]> queue = new LinkedList();
            queue.add(temp);

            while (!queue.isEmpty()) {
                int[] qTemp = queue.poll();
                virusVisited[temp[0]][temp[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = qTemp[0] + dx[i];
                    int ny = qTemp[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }

                    if (array[nx][ny] == 0 && !virusVisited[nx][ny]) {
                        virusVisited[nx][ny] = true;
                        array[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        // cal 메서드 호출
        cal(array);
        // 사용한 배열 초기화
        virusVisited = new boolean[n][m];
    }

    // 남아있는 0이 몇개인지 세는 메서드
    static void cal(int[][] array) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) {
                    cnt++;
                }
            }
        }
        // list에 저장
        cntList.add(cnt);
    }
}

