package progammers;

import java.util.Arrays;

public class Carpat_L2 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 1; i <= total; i++) {
            // 세로 길이
            int row = i;
            // 가로 길이
            int col = total / row;
            

            // 가로 길이가 세로 길이와 같거나 세로보다 길기 떄문에
            if(row > col) {
                continue;
            }
            // 가로 - 2 * 세로 - 2 가 노란색 개수이므로
            if((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                // return answer;
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
