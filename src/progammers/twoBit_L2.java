package progammers;

import java.util.Arrays;

public class twoBit_L2 {
    public static void main(String[] args) {
        long[] numbers = {2, 7, 3};
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i] + 1;

            while (true) {
                if(Long.bitCount(numbers[i]^n) <= 2) {
                    answer[i] = n;
                    break;
                }
                n++;
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
