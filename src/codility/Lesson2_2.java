package codility;

import java.util.Arrays;
import java.util.Stack;

public class Lesson2_2 {
    class Solution {
        public int solution(int[] A) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            Arrays.sort(A);

            for (int i : A) {
                if ((!stack.isEmpty()) && stack.peek() == i) {
                    stack.pop();
                } else {
                    stack.add(i);
                }
            }
            answer = stack.pop();

            return answer;
        }
    }

}
