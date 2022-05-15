package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1260 {
    static int n, m, v;
    static boolean[] visit;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // dfs와 bfs의 탐색값을 저장할 배열
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i < n + 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 간선이 양방향이므로
            arr[a][b] = arr[b][a] = 1;
        }
        System.out.println(Arrays.deepToString(arr));

    }

    public static void dfs(int n, int m) {
        for (int i = 0; i < n + 1; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(n, m);

            }
        }
    }

    public static void bfs() {

    }
}
