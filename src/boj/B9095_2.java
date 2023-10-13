package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095_2 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }
        // bottom-up 방식
        for (int i : n) {
            bottomUp(i);
            System.out.println(answer);
            answer = 0;
        }
    }

    static void bottomUp(int num) {
//        int[] dp = new int[num + 1]; 런타임 에러
        int[] dp = new int[11];
        // 1을 만드는 방법의 수
        dp[1] = 1;
        // 2를 만드는 방법의 수
        dp[2] = 2;
        // 3을 만드는 방법의 수
        dp[3] = 4;
        for (int i = 4; i < num + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        answer = dp[num];
    }
}
