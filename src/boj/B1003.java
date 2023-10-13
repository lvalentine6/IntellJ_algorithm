package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1003 {
    static int t;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            dp(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb);
    }

    public static StringBuilder dp(int num) {
        dp = new int[num + 2][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        return sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
    }
}
