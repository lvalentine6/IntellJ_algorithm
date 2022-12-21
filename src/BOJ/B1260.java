package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
    static int n, m, v;
    static boolean[] visit;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[][] arr;
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        sb = new StringBuilder();

        // 입력을 배열로 저장
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 간선이 양방향이므로
            arr[a][b] = arr[b][a] = 1;
        }
        // dfs 실행
        dfs(v);
        // 공백추가
        sb.append("\n");
        // visit 배열 초기화
        visit = new boolean[n + 1];
        //bfs 실행
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(" ");
        for (int i = 1; i < n + 1; i++) {
            if (arr[v][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visit[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v).append(" ");
            for (int i = 1; i < n + 1; i++) {
                if (arr[v][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
