package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2166 {
    static int n;
    static long[] x, y;
    static double resultX, resultY, resultSum;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = new long[n + 1];
        y = new long[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // 신발끈 공식
        x[n] = x[0];
        y[n] = y[0];

        area(x, y);
        System.out.println(String.format("%.1f", resultSum));

    }

    // 넓이를 구하는 메서드
    static void area(long[] x, long[] y) {
        for (int i = 0; i < n; i++) {
            resultX += x[i] * y[i + 1];
            resultY += x[i + 1] * y[i];
            resultSum = Math.abs(resultX - resultY) / 2;
        }
    }
}
