package progammers;

import java.util.*;

public class MinNumber_L2 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int answer = 0;

        PriorityQueue Aqueue = new PriorityQueue();
        PriorityQueue Bqueue = new PriorityQueue(Collections.reverseOrder());

        // A의 최솟값과 B의 최댓값을 각 큐에 넣기
        for (int i : A) {
            Aqueue.add(i);
        }

        for (int i : B) {
            Bqueue.add(i);
        }

        // 최솟값과 최댓값을 빼서 처리
       for (int i = 0; i < A.length; i++) {
            int min = (int) Aqueue.poll();
            int max = (int) Bqueue.poll();
            answer += min * max;
        }
        System.out.println(answer);
    }
}
