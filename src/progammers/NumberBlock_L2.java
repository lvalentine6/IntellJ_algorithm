package progammers;

import java.util.Arrays;

public class NumberBlock_L2 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 20;

        int beginInt = (int) begin;
        int endInt = (int) end;
        int[] answer = new int[(endInt - beginInt + 1)];
        int idx = 0;

        for (int i = beginInt; i <= endInt; i++) {
            // 소수 판별을 위한 변수
            boolean flag = false;

            // i가 1이면 지나감
            if (i == 1) {
                answer[idx++] = 0;
                continue;
            }

            // 에라토테네스의 채로 소수인지 판별
            for (int j = 2; j * j <= i; j++) {
                // 소수가 아니고 약수가 10000000 이하라면
                if (i % j == 0 && i / j <= 10000000) {
                    // 가장 큰 약수 삽입
                    answer[idx++] = i / j;
                    flag = true;
                    break;
                }
            }

            // 소수라면 1 삽입
            if (!flag) {
                answer[idx++] = 1;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
