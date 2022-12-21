package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463_2 {
    // 첫번째 순회에서 int의 최댓값과 answer 비교를 위해 전역 변수 선언
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //topDown 방식
        topDown(n, 0);
        System.out.println(answer);
    }

    static void topDown(int num, int cnt) {
        // 재귀 탈출문
        if (num == 1) {
            answer = Math.min(cnt, answer);
            return;
        }

        // 최솟값보다 카운팅이 많아지면 리턴
        if (cnt > answer) {
            return;
        }

        // 2로 나누어 떨어지면
        if (num % 2 == 0) {
            topDown(num / 2, cnt + 1);
        }
        // 3으로 나누어 떨어지면
        if (num % 3 == 0) {
            topDown(num / 3, cnt + 1);
        }
        // 그게 아니면
        topDown(num - 1, cnt + 1);
    }
}
