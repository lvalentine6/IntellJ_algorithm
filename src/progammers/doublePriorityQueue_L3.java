package progammers;

import java.util.*;

public class doublePriorityQueue_L3 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = new int[2];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            String commend = temp[0];
            int num = Integer.parseInt(temp[1]);

            if(commend.equals("I")) {
                queue.offer(num);
            } else if (commend.equals("D") && num == 1) {
                if(!queue.isEmpty()) {
                    PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
                    for (int j = 0; j <= queue.size(); j++) {
                        queue2.offer(queue.poll());
                    }
                    queue2.remove();
                    for (int j = 0; j <= queue2.size(); j++) {
                        queue.offer(queue2.poll());
                    }
                }
            } else {
                if(!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }

        if (queue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = queue.poll();
            PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i <= queue.size(); i++) {
                result.offer(queue.poll());
            }
            answer[1] = result.poll();
        }

        System.out.println(Arrays.toString(answer));
    }
}
