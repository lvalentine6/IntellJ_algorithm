package progammers;

import java.util.Stack;

public class ToyGame {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int answer = 0;

        // 인형을 담을 스택
        Stack<Integer> st = new Stack<>();

        // 인형 세로배열로 바꾸기
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                temp[i][j] = board[j][i];
            }
        }

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                // 인형이 없으면
                if (temp[moves[i] - 1][j] == 0) {
                    continue;
                } else {
                    // 같은 모양의 인형 제거하고 점수
                    if (!st.isEmpty() && temp[moves[i] - 1][j] == st.peek()) {
                        answer += 2;
                        st.pop();
                    } else {
                        // 인형 뽑기
                        st.add(temp[moves[i] - 1][j]);
                    }
                    // 뽑은 인형 0으로 초기화
                    temp[moves[i] - 1][j] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
