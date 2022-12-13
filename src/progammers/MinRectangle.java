package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int answer = 0;

        // 가로, 세로 길이 list 생성
        List<Integer> ltemp = new ArrayList<>();
        List<Integer> htemp = new ArrayList<>();

        // 가로 길이의 최대값, 세로 길이의 최소값
        for (int i = 0; i < sizes.length; i++) {
            int c1 = sizes[i][0];
            int c2 = sizes[i][1];
            ltemp.add(Math.max(c1, c2));
            htemp.add(Math.min(c1, c2));
        }

        // 가로 길이의 최대값중 가장 큰값, 세로 길이의 최소값중 가장 큰값
        int length = Collections.max(ltemp);
        int height = Collections.max(htemp);
        answer = length * height;

        System.out.println(answer);
    }
}
