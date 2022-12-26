package progammers;

import java.util.ArrayList;
import java.util.Comparator;
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

//        list.sort(Collections.reverseOrder());
        list.sort(Comparator.reverseOrder());

        int repeat = list.size() / m;
        int firstIndex = 0;
        int lastIndex = m;

        for (int i = 0; i < repeat; i++) {
            List<Integer> subList = list.subList(firstIndex, lastIndex);
            firstIndex = lastIndex;
            lastIndex += m;
//            answer += Collections.min(subList) * m;
            answer += subList.get(lastIndex - firstIndex - 1) * m;
        }

        System.out.println(answer);
    }
}
