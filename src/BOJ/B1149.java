package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    static int n;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        // 첫번쨰 집 지정
        for (int i = 0; i < 3; i++) {
            cal(0, i, 0);
        }
        System.out.println(answer);
    }

    // 완전탐색 메서드
    static void cal(int idx, int preIdx, int price) {
        int result = price;
        result += arr[idx][preIdx];

        if (idx == n - 1) {
            answer = Math.min(answer, result);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (preIdx != i) {
                cal(idx + 1, i, result);
            }
        }
    }
}
