package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoi_L2 {
    static List<int[]> list;

    public static void main(String[] args) {
        int n = 3;
        list = new ArrayList<>();

        // 재귀 호출
        recursion(1, 2, 3, n);

        // 배열 출력
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }

        System.out.println(Arrays.deepToString(answer));

    }

    // 재귀 메서드
    static void recursion(int start, int via, int end, int n) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        // 1번 기둥에서 3번 기둥을 거쳐 2번 기둥으로
        recursion(start, end, via, n - 1);
        list.add(new int[]{start, end});
        // 2번 기둥에서 1번 기둥을 거쳐 3번 기둥으로
        recursion(via, start, end, n - 1);
    }
}
