package progammers;

import java.util.Stack;

public class FoodFight_L1 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                stack.add(i);
                stringBuilder.append(i);
            }
        }

        stringBuilder.append(0);
        int stackSize = stack.size();

        for (int j = 0; j < stackSize; j++) {
            stringBuilder.append(stack.pop());
        }

        answer = stringBuilder.toString();
        System.out.println(answer);
    }
}
