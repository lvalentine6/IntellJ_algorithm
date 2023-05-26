package progammers;

public class KeyPad_LH {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        int leftHand = 10;
        int zero = 11;
        int rightHand = 12;
        for (int i = 0; i < numbers.length; i++) {
            // 1, 4, 7 인 경우
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                stringBuilder.append("L");
                leftHand = numbers[i];
                continue;
            }
            // 3, 6, 9 인 경우
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                stringBuilder.append("R");
                rightHand = numbers[i];
                continue;
            }

            // number[i] == 0 인 경우 10으로 바꾸기
            if (numbers[i] == 0) {
                numbers[i] = zero;
            }

            // 2,5,8,0 인 경우
            int leftDistance = calculateDistance(leftHand, numbers[i]);
            int rightDistance = calculateDistance(rightHand, numbers[i]);

            if (leftDistance < rightDistance) {
                stringBuilder.append("L");
                leftHand = numbers[i];
            } else if (leftDistance > rightDistance) {
                stringBuilder.append("R");
                rightHand = numbers[i];
            } else {
                stringBuilder.append(hand.toUpperCase().charAt(0));
                if (stringBuilder.substring(stringBuilder.length() - 1).equals("L")) {
                    leftHand = numbers[i];
                    continue;
                }
                rightHand = numbers[i];
            }
        }
        answer = stringBuilder.toString();
        return answer;
    }

    public static int calculateDistance(int hand, int number) {
        int[][] keyPad = {
                {0, 0}, {0, 1}, {0, 2},
                {1, 0}, {1, 1}, {1, 2},
                {2, 0}, {2, 1}, {2, 2},
                {3, 0}, {3, 1}, {3, 2}};
        int x = Math.abs(keyPad[hand - 1][0] - keyPad[number - 1][0]);
        int y = Math.abs(keyPad[hand - 1][1] - keyPad[number - 1][1]);
        return x + y;
    }
}
