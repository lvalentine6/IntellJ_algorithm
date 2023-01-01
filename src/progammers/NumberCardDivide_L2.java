package progammers;

import java.util.*;

public class NumberCardDivide_L2 {
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {5, 17};
        int answer = 0;

        int divideNumberA = 1;

        int min = Arrays.stream(arrayA).min().getAsInt();

        while (divideNumberA < min) {
            boolean flag2 = false;
            for (int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % divideNumberA != 0) {
                    flag2 = true;
                    break;
                }
            }
//            if(!flag2) {
//                for (int i = 0; i < arrayA.length; i++) {
//                    arrayA[i] = arrayA[i] / divideNumberA;
//                }
//            }
            divideNumberA++;
        }
        System.out.println(divideNumberA);
        System.out.println(answer);
    }
}
