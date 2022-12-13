package progammers;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = "";

        // * 0 # 바꾸기
        int left = 10;
        int mid = 11;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            // 1 4 7 이면
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            }
            // 3 6 9 이면
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            }
            // 2 5 8 0 이면
            else {
                //numbers[i] 가 0이면 mid로 바꾸기
                if (numbers[i] == 0) {
                    numbers[i] = mid;
                }
                int lp = xy(numbers[i], left);
                int rp = xy(numbers[i], right);

                // 왼쪽손보다 오른쪽손이 더 가까운 경우
                if (lp > rp) {
                    answer += "R";
                    right = numbers[i];
                }
                // 오른쪽손보다 왼쪽손이 더 가까운 경우
                else if (lp < rp) {
                    answer += "L";
                    left = numbers[i];
                }
                // 왼쪽손과 오른쪽손 거리가 같은 경우
                else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];

                    } else {
                        answer += "R";
                        right = numbers[i];
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int xy(int n, int p) {
        // 키패드를 좌표로 변수 설정
        int[][] keypad = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 1},
                {3, 2}};
        // x 좌표 거리 계산
        int xx = Math.abs(keypad[p - 1][0] - keypad[n - 1][0]);
        // y 좌표 거리 계산
        int yy = Math.abs(keypad[p - 1][1] - keypad[n - 1][1]);
        return xx + yy;
    }
}
