package progammers.preTest2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//        int[] topping = {1, 2, 3, 1, 4};
        int answer = 0;

        int[] arr1 = new int[topping.length + 1];
        int[] arr2 = new int[topping.length + 1];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            set1.add(topping[i]);
            arr1[topping[i]]++;
        }

        for (int i = 0; i < topping.length; i++) {
            set2.add(topping[i]);

            arr1[topping[i]]--;
            arr2[topping[i]]++;

            if(arr1[topping[i]] == 0) {
                set1.remove(topping[i]);
            }

            if(set1.size() == set2.size()) {
                answer++;
            }
        }

        System.out.println(set1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(answer);
    }
}
