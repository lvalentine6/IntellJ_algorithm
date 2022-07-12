package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        // 입력값 각 배열에 삽입
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                // 이전까지 계산했던 가치를 저장
                dp[i][j] = dp[i - 1][j];
                // j의 무게에서 현재 아이템의 무게를 뺐을때 남는 무게가 존재한다면
                if (j - w[i] >= 0) {
                    // 이전에 저장한 값, 남은 무게의 가치 + 현재 가치중 큰 값을 저장
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
