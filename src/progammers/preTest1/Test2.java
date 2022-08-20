package progammers.preTest1;

import java.util.*;
// 풀이시간 : 30분
public class Test2 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int start = 0;
        int end = 10;

        while (start <= discount.length) {
            Map<String, Integer> disMap = new HashMap<>();
            if(start + 10 >= discount.length) {
                end = discount.length;
            }
            for (int i = start; i < end; i++) {
                disMap.put(discount[i], disMap.getOrDefault(discount[i], 0) + 1);
            }
            start++;
            end++;
            if (wantMap.equals(disMap)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
