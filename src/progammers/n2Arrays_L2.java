package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2Arrays_L2 {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;

        int[][] arr = new int[n][n];

        int idx = 1;
        while (idx <= n) {
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < idx; j++) {
                    if(arr[i][j] == 0) {
                        arr[i][j] = idx;
                    }
                }
            }
            idx++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(arr[i][j]);
            }
        }

        List<Integer> sub = new ArrayList<>(list.subList((int) left, (int) right + 1));

        int[] answer = new int[sub.size()];
        for (int i = 0; i < sub.size(); i++) {
            answer[i] = sub.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
