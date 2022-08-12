package Codility;

import java.util.*;

public class Lesson2_1 {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;

        int[] answer = new int[A.length];

        Deque<Integer> deque = new LinkedList<>();

        for (int i : A) {
            deque.add(i);
        }

        for (int i = 0; i < K; i++) {
            int temp = deque.pollLast();
            deque.addFirst(temp);
        }

        for (int i = 0; i < A.length; i++) {
            answer[i] = deque.poll();
        }

        return answer;
    }
}
