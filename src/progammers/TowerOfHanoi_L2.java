package progammers;

import java.util.Arrays;
import java.util.Stack;

public class TowerOfHanoi_L2 {
    public static void main(String[] args) {
        int n = 2;
        int[][] answer = new int[3][n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n; i > 0; i--) {
            stack.add(i);
        }

        System.out.println(stack);
        System.out.println(Arrays.deepToString(answer));
    }
}
