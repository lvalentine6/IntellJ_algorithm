package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 BufferedReader를 사용해 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader는 String 형식으로만 반환 (Int 형변환)
        int n = Integer.parseInt(br.readLine());
        // bottom-up 방식
        System.out.println(bottomUp(n));
    }

    static int bottomUp(int num) {
        // 1부터 num까지의 배열 선언
        int[] dp = new int[num + 1];
        // num까지 실행해야 함으로 i <= num 까지 or i < num+1 까지
        for (int i = 2; i <= num; i++) {
            // 1을 빼줬을때 횟수 저장
            dp[i] = dp[i - 1] + 1;
            // 2로 나누어 떨어진다면
            if (i % 2 == 0) {
                // 1을 뺴줬을때 횟수와 2로 나눈수의 횟수에 1을 더한 값 비교
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3으로 나누어 떨어진다면
            if (i % 3 == 0) {
                // 1을 뺴줬을때 횟수와 2로 나눈수의 횟수에 1을 더한 값 비교
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[num];
    }
}
