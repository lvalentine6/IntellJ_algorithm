package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitSeller_L1 {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i : score) {
            list.add(i);
        }

        list.sort(Collections.reverseOrder());
        int repeat = list.size() / m;

        int first = 0;
        int last = m;

        for (int i = 0; i < repeat; i++) {
            List<Integer> subList = list.subList(first, last);
            first = last;
            last += m;
            answer += Collections.min(subList) * m;
        }

        System.out.println(answer);
    }
}
