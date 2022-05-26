package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11727 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bottomUp(n));

    }
    static int bottomUp(int num) {
        int[] dp = new int[num + 2];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < num + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }
        return dp[num];
    }
}
