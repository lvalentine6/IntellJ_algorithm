package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        visited = new boolean[n][3];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, -1);
        System.out.println(answer);

    }

    static void dfs(int idx, int price, int preIdx) {
        if (idx == n) {
            answer = Math.min(answer, price);
            return;
        }
        for (int i = idx; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (!visited[i][j]) {
                    if(j == preIdx) continue;
                    visited[i][j] = true;
                    price += arr[i][j];
                    dfs(idx + 1, price, j);
                    visited[i][j] = false;
                    price -= arr[i][j];
                }
            }
        }
    }
}
