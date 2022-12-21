package progammers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 20;
        int answer = 0;

        // 큐에 넣기전에 정렬
        Arrays.sort(d);
        Queue<Integer> qu = new LinkedList<>();

        // d의 원소 큐에 넣기
        for (int i : d) {
            qu.add(i);
        }

        // 신청금액을 더하기 위한 변수
        int num = 0;
        // 신청금액의 합이 예산을 넘지 않으면서 큐가 비어 있지 않을때까지
        while (!(num >= budget) && !(qu.isEmpty())) {
            // 지금까지의 합과 다음 신청금액의 합이 예산을 넘지 않으면
            if (num + qu.peek() <= budget) {
                num += qu.poll();
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}
