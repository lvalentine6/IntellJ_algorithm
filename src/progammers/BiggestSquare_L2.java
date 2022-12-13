package progammers;

import java.util.Arrays;

public class BiggestSquare_L2 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int answer = 0;

        // 계산을 위한 배열 만들기
        int[][] temp = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                temp[i + 1][j + 1] = board[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (temp[i][j] == 1) {
                    int left = temp[i][j - 1];
                    int up = temp[i - 1][j];
                    int leftup = temp[i - 1][j - 1];
                    int min = Math.min(left, Math.min(up, leftup));
                    temp[i][j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }
        answer = max * max;

        System.out.println(Arrays.deepToString(temp));
        System.out.println(answer);
    }
}
