package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {

    static int answer;
    static int[] score;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 계단이 1개일 경우를 생각해서 n+2 배열 생성
        score = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        answer = 0;
        // topDown 방식 사용시 초기값이 null인게 편하므로
        dp = new Integer[n + 2];

        // topDown 방식 사용시 배열의 초기값이 null이므로 dp[0]에는 0으로 초기화
        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        // topDown 방식
        System.out.println(topDown(n));

        // bottomUp 방식
//        bottomUp(n);
//        System.out.println(answer);

    }

    public static void bottomUp(int num) {
        // 점화식 적용
        for (int i = 3; i < num + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }
        answer = dp[num];
    }

    public static int topDown(int num) {
        // 아직 탐색하지 않은 dp일경우 재귀호출
        if (dp[num] == null) {
            dp[num] = Math.max(topDown(num - 3) + score[num - 1], topDown(num - 2)) + score[num];
        }
        return dp[num];
    }
}
