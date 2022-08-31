package progammers;

import java.util.LinkedList;
import java.util.Queue;

public class twoQueue_L2 {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

//        int[] queue1 = {1, 1};
//        int[] queue2 = {1, 5};

        int answer = 0;
        long sumQ1 = 0;
        long sumQ2 = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        // 두 큐의 합 구하기
        for (int i = 0; i < queue1.length; i++) {
            sumQ1 += queue1[i];
            q1.add((long) queue1[i]);
            sumQ2 += queue2[i];
            q2.add((long) queue2[i]);
        }

        Queue<Long> q1Clone = new LinkedList<>(q1);
        Queue<Long> q2Clone = new LinkedList<>(q2);
        long target = (sumQ1 + sumQ2) / 2;

        while (!(sumQ1 == target)) {
            long temp = 0;
            if(sumQ1 < sumQ2) {
                temp = q2.poll();
                q1.add(temp);
                sumQ2 -= temp;
                sumQ1 += temp;
            } else {
                temp = q1.poll();
                q2.add(temp);
                sumQ1 -= temp;
                sumQ2 += temp;
            }
            if(q1.equals(q1Clone)) {
                answer = -1;
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
