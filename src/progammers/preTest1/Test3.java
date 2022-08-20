package progammers.preTest1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
//        int[] order = {5, 4, 3, 2, 1};
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }

        int idx = 0;

        Stack<Integer> stack = new Stack<>();

        while (idx != order.length) {
            int orderTemp = order[idx];
            if (((!stack.isEmpty()) && stack.peek() == orderTemp)) {
                stack.pop();
                answer++;
                idx++;
            } else if((!queue.isEmpty()) && queue.peek() == orderTemp) {
                queue.poll();
                answer++;
                idx++;
            } else {
                stack.push(queue.poll());
            }
        }

        System.out.println(answer);
    }
}
