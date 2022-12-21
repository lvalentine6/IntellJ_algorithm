package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divisor {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        int answer[] = list.stream().mapToInt(i -> i).toArray();
    }
}
