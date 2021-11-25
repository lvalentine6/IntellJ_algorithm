package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoNumberPlus {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(list.get(i) == numbers[j]) {
                    list.remove(list.get(i));
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        System.out.println(answer);
    }
}
