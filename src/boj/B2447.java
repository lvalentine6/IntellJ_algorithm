package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2447 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        // 배열을 빈칸으로 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        // 재귀 호출
        rec(0, 0, n);

        // 배열을 탐색하며 StringBuilder에 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rec(int x, int y, int num) {
        // 재귀 탈출
        if (num == 1) {
            arr[x][y] = '*';
            return;
        }
        // x,y 값을 바꿔주며 재귀 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 빈칸으로 있어야 하는 곳이라면
                if (!(i == 1 && j == 1)) {
                    rec(x + i * (num / 3), y + j * (num / 3), num / 3);
                }
            }
        }
    }
}
