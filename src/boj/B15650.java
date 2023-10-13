package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {

    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append('\n');
            return;
        }
        // idx를 증가시키면서 idx부터 재귀 호출
        for (int i = idx; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
