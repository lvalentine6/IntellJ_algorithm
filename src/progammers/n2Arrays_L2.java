package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2Arrays_L2 {
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        // 값을 저장할 list
        List<Long> list = new ArrayList<>();

        // Max(행, 열)이 값
        for (long i = left; i <= right; i++) {
            list.add(Math.max(i / n, i % n) + 1);
        }

        // list answer 배열에 복사
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Math.toIntExact(list.get(i));
        }

        System.out.println(Arrays.toString(answer));
    }
}
