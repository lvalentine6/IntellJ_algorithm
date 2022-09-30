package progammers;

import java.util.*;

public class doublePriorityQueue_L3 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = {0, 0};

        // 낮은 숫자 우선순위 큐
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        // 높은 숫자 우선순위 큐
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            String commend = temp[0];
            int num = Integer.parseInt(temp[1]);

            // 명령어가 삽입인 경우
            if (commend.equals("I")) {
                queue1.add(num);
                queue2.add(num);
                // 명령어가 삭제인 경우
            } else {
                // queue가 비어있지 않으면
                if (!queue1.isEmpty()) {
                    // 최솟값 삭제인 경우
                    if (num == -1) {
                        int t = queue1.peek();
                        queue1.remove();
                        queue2.remove(t);
                        // 최댓값 삭제인 경우
                    } else {
                        int t = queue2.peek();
                        queue2.remove();
                        queue1.remove(t);
                    }
                }
            }
        }

        // queue가 비어있지 않으면
        if (!queue1.isEmpty()) {
            answer[0] = queue2.poll();
            answer[1] = queue1.poll();
        }

        System.out.println(Arrays.toString(answer));
    }
}
