package progammers;

public class Tictactoe_L2 {
    static int answer = 0;

    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 1;

        int firstCnt = 0;
        int secondCnt = 0;

        for (int i = 0; i < board.length; i++) {
            String temp = board[i];
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch == 'O') {
                    firstCnt++;
                } else if (ch == 'X') {
                    secondCnt++;
                }
            }
        }

        if (firstCnt < secondCnt || firstCnt > secondCnt + 1) {
            return 0;
        }

        if (checkBoard(board, 'O')) {
            if (firstCnt == secondCnt) {
                return 0;
            }
        }

        if (checkBoard(board, 'X')) {
            if (firstCnt != secondCnt) {
                return 0;
            }
        }

        return answer;
    }

    public static boolean checkBoard(String[] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == symbol && board[i].charAt(1) == symbol
                    && board[i].charAt(2) == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == symbol && board[1].charAt(i) == symbol
                    && board[2].charAt(i) == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(0) == symbol && board[1].charAt(1) == symbol
                    && board[2].charAt(2) == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(2) == symbol && board[1].charAt(1) == symbol
                    && board[2].charAt(0) == symbol) {
                return true;
            }
        }

        return false;
    }

}
