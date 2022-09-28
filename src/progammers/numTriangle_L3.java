package progammers;

import java.util.Arrays;

public class numTriangle_L3 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = 0;

        int sum = 0;

        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                sum = triangle[i][j] > triangle[i][j + 1] ? triangle[i][j] : triangle[i][j + 1];
                triangle[i - 1][j] += sum;
            }
        }

        answer = triangle[0][0];

        System.out.println(Arrays.deepToString(triangle));
        System.out.println(answer);
    }
}
