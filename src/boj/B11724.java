package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724 {
    static int n, m;
    static int arr[][];
    static boolean visit[];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        // 방문한적이 없다면 dfs 실행
        for (int i = 1; i < n + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int num) {
        visit[num] = true;
        for (int i = 1; i < n + 1; i++) {
            if (!visit[i] && arr[num][i] == 1) {
                dfs(i);
            }
        }
    }
}
