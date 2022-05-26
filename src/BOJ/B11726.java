package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11726 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bottomUp(n));
    }
    public static int bottomUp(int num) {
        // 입력값이 1일 경우를 대비해서 배열 생성
        int[] dp = new int[num + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < num + 1; i++) {
            // 오버플로우 방지를 위해
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        return dp[num];
    }
}
