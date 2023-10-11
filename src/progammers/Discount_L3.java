package progammers;

import java.util.HashMap;
import java.util.Map;

public class Discount_L3 {
    public static void main(String[] args) {
        int answer = 0;
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"};

        // i부터 10일간 할인 품목 map에 넣기
        for (int i = 0; i < discount.length; i++) {
            Map<String, Integer> dis = new HashMap<>();
            int cnt = 0;
            for (int j = i; j < discount.length; j++) {
                // 10일이 지나면 중단
                if (cnt == 10) {
                    break;
                }
                dis.put(discount[j], dis.getOrDefault(discount[j], 0) + 1);
                cnt++;
            }

            // number와 map의 값을 비교
            boolean flag = false;
            for (int j = 0; j < want.length; j++) {
                // map에 want 물품이 없으면 탐색 종료
                if (dis.get(want[j]) == null) {
                    flag = true;
                    break;
                }
                // map의 값보다 want 값이 크면
                if (number[j] > dis.get(want[j])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
