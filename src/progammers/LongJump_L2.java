package progammers;

public class LongJump_L2 {
    public static void main(String[] args) {
        int n = 1;
        long answer = 0;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        answer = dp[n];

        System.out.println(answer);
    }
}
