package progammers.preTest2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//        int[] topping = {1, 2, 3, 1, 4};
        int answer = 0;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 1; i < topping.length; i++) {
            for (int j = 0; j < i; j++) {
                set1.add(topping[j]);
            }
            for (int j = i; j < topping.length; j++) {
                set2.add(topping[j]);
            }

            if(set1.size() == set2.size()) {
                answer++;
            }

            set1.clear();
            set2.clear();
        }

        System.out.println(answer);
    }
}
