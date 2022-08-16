package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi_L2 {
    public static void main(String[] args) {
        int n = 3;
        List<int[]> list = new ArrayList<>();
        Stack<Integer> f = new Stack<>();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();

        for (int i = n; i > 0; i--) {
            f.add(i);
        }

        while (!(f.isEmpty())) {
            if (f.size() == 1) {
                t.push(f.pop());
                list.add(new int[]{1, 3});
            } else {
                s.push(f.pop());
                list.add(new int[]{1, 2});
            }
        }

        while (!(s.isEmpty())) {
            if (s.size() > 0) {
                t.push(s.pop());
                list.add(new int[]{2, 3});
            }
        }

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }

        System.out.println(Arrays.deepToString(answer));

    }
}
