package progammers;

import java.util.Arrays;

public class MinMax_L2 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String answer = "";

        // s를 공백으로 잘라서 최댓값, 최솟값 추출
        int[] temp = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(temp).min().getAsInt();
        int max = Arrays.stream(temp).max().getAsInt();

        answer += min + " " + max;

        System.out.println(answer);
    }
}
