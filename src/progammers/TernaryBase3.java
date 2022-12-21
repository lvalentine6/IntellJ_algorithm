package progammers;

import java.util.ArrayList;
import java.util.List;

public class TernaryBase3 {
    public static void main(String[] args) {
        int n = 45;
        int answer = 0;

        // 3진법으로 변환해 리스트에 저장
        List<Integer> list = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            list.add(temp % 3);
            temp /= 3;
        }

        // 10진법으로 변환하기 위한 지수 변수
        int pow = list.size();
        for (int i = 0; i < list.size(); i++) {
            pow--;
            answer += list.get(i) * (int) Math.pow(3, pow);
        }

        System.out.println(answer);
    }
}
