package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }
        // top-down 방식
        for (int i : n) {
            topDown(i);
            System.out.println(answer);
            answer = 0;
        }
    }

    static void topDown(int num) {
        // 재귀 탈출조건
        if (num == 0) {
            answer++;
            return;
        }
        // 1뺴기
        if (num - 1 >= 0) {
            topDown(num - 1);
        }
        // 2빼기
        if (num - 2 >= 0) {
            topDown(num - 2);
        }
        // 3빼기
        if (num - 3 >= 0) {
            topDown(num - 3);
        }
    }
}
