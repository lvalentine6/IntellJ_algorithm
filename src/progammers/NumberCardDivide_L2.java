package progammers;

import java.util.*;

public class NumberCardDivide_L2 {
    public static void main(String[] args) {
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        int answer = 0;

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < arrayA.length; i++) {
            int num = arrayA[i];
            for (int j = 1; j <= num; j++) {
                if(num % j == 0) {
                    set.add(j);
                }
            }
        }

        for (int i = 0; i < set.size(); i++) {
            List<Integer> list = new ArrayList<>(set);
            int temp = list.get(i);

            boolean flagA = false;
            for (int j = 0; j < arrayA.length; j++) {
                if(arrayA[j] % temp != 0) {
                    flagA = true;
                    break;
                }
            }

            boolean flagB = false;
            for (int j = 0; j < arrayB.length; j++) {
                if(arrayB[j] % temp == 0) {
                    flagB = true;
                    break;
                }
            }
            if (!flagA && !flagB) {
                answer = Math.max(temp, answer);
            }
        }
        System.out.println(answer);
    }
}
