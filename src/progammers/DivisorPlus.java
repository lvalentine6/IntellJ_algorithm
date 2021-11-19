package progammers;

import java.util.ArrayList;
import java.util.List;

public class DivisorPlus {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int answer = 0;

        // 수 구해서 리스트에 저장
        List<Integer> num = new ArrayList<>();
        int temp = 0;

        while (left != right + 1) {
            num.add(left++);
        }

        for (int i = 0; i < num.size(); i++) {
            // 약수의 개수 측정 변수
            int dnum = 0;
            for (int j = 1; j <= num.get(i); j++) {
                if(num.get(i) % j == 0) {
                    dnum++;
                }
            }
            // 홀수면
            if (dnum % 2 != 0) {
                temp = num.get(i) * -1;
            }
            // 짝수면
            else {
                temp = num.get(i);
            }
            answer += temp;
        }

        System.out.println(answer);
        System.out.println(num);
    }
}
