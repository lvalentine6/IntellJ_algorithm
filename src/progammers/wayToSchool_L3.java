package progammers;

import java.util.Arrays;

public class wayToSchool_L3 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        int answer = 0;

        int[][] arr = new int[n][m];
        arr[0][0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            arr[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                    continue;
                }

                if(i != 0) {
                    arr[i][j] += arr[i - 1][j] % 1000000007;
                }

                if(j != 0) {
                    arr[i][j] += arr[i][j - 1] % 1000000007;
                }
            }
        }

        answer = arr[n - 1][m - 1];
        System.out.println(answer);
    }
}
