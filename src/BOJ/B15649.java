package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);

    }
    public static void dfs(int n, int m, int depth) {
        // 재귀를 탈출하고 출력
        if(depth == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            // i를 방문하지 않았다면
            if(visit[i] == false) {
                visit[i] = true;
                arr[depth] = i + 1;
                // depth를 증가시키고 재귀 호출
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}
