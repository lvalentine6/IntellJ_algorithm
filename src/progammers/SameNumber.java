package progammers;

import java.util.ArrayList;
import java.util.List;

public class SameNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        List<Integer> list = new ArrayList<>();
        int temp = 10;

        for (int i = 0; i < arr.length; i++) {
            if (temp != arr[i]) {
                list.add(arr[i]);
            }
            temp = arr[i];
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();

        System.out.println(list);
    }
}
