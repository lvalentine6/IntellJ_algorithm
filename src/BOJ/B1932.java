package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {
    static int n;
    static Integer[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 입력값 배열에 삽입
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp의 값이 0일수도 있으므로 Integer로 초기화
        dp = new Integer[n][n];

        // 배열의 마지막 값 dp 배열에 복사
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }
        System.out.println(search(0, 0));
    }

    static int search(int idx, int depth) {
        // 재귀 탈출문
        if (depth == n - 1) {
            return dp[depth][idx];
        }
        // 다음 배열의 왼쪽과 오른쪽중 더 큰값을 찾아 현재 배열의 값과 더하기
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(search(idx, depth + 1), search(idx + 1, depth + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
