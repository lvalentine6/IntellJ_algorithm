package progammers;

import java.util.*;

public class NumberArray {
    public static void main(String[] args) {
        long n = 12345;

        String s = String.valueOf(n);
        String[] temp = s.split("");
        List<String> list = new ArrayList<>();
        for(String i : temp) {
            list.add(i);
        }
        Collections.reverse(list);
        temp = list.toArray(new String[list.size()]);
        int[] answer = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(answer));

    }
}
