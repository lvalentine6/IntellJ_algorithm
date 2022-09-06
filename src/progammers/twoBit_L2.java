package progammers;

import java.util.Arrays;

public class twoBit_L2 {
    public static void main(String[] args) {
        long[] numbers = {2, 7, 13, 71};
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Long.toString(numbers[i], 2));

            // 짝수라면
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            String n = Long.toString(numbers[i], 2);

            // 홀수이면서 1로만 이루어져 있다면
            if(!n.contains("0")) {
                // String 2번째 자리에 0 삽입
                String temp = n.substring(0, 1) + "0" + n.substring(1);
                // 10진수로 변환 후 answer 배열에 삽입
                answer[i] = Long.parseLong(temp, 2);
                // 홀수이면서 1과 0이 포함되어 있다면
            } else {
                // 마지막으로 0이 나오는 인덱스 찾기
                int idx = n.lastIndexOf("0");
                // 문자열 다시 만들기
                n = n.substring(0, idx) + "10" + n.substring(idx + 2);
                answer[i] = Long.parseLong(n, 2);
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
