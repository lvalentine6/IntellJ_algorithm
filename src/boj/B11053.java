package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        // 입력값 배열 삽입
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        for (int i = 0; i < n; i++) {
            // dp의 값 1로 초기화
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // arr를 돌며 i가 j의 값보다 크고 이전 dp의 크기보다 작으면
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // dp에서 최댓값 찾기
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }
}
