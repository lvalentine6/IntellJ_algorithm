package progammers;

import java.util.Collections;
import java.util.PriorityQueue;

public class nightWork_L3 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        long answer = 0;

        // 내림차순 우선순위 큐 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 큐에 배열값 넣기
        for (int i = 0; i < works.length; i++) {
            queue.add(works[i]);
        }

        while (n > 0) {
            // 가장 큰 수가 0이면 탐색중단
            if (queue.peek() == 0) {
                break;
            }
            queue.add(queue.poll() - 1);
            n--;
        }

        // 큐에 있는 값 제곱해서 더하기
        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }

        System.out.println(answer);

    }
}
