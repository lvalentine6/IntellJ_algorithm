package progammers;

import java.util.Arrays;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 10;
        int answer = 0;

        // 0번째 버리고 1번째 배열부터 사용하기 위해 n+1 개 배열 생성
        int[] list = new int[n + 1];

        // 1은 소수가 아니므르 2부터 n까지 배열에 추가
        for (int i = 2; i <= n; i++) {
            list[i] = i;
        }

        // 2부터 i의 배수들을 0으로 만들기
        for (int i = 2; i <= n; i++) {
            // 0이 이면 넘어가고 아니면 0으로 만들기
            if (list[i] == 0) {
                continue;
            }
            // 자기 자신을 제외한 i의 배수를 0으로 만들기
            for (int j = 2 * i; j <= n; j += i) {
                list[j] = 0;
            }
        }

        // 0이 아닌것 카운트
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                answer++;
            }
        }

        System.out.println(Arrays.toString(list));
        System.out.println(answer);
    }
}
