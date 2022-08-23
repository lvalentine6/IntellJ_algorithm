package progammers.preTest2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    static int cnt;
    static List<List<Integer>> list;
    public static void main(String[] args) {
//        int[] number = {-2, 3, 0, 2, -5};
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int answer = 0;
        cnt = 0;
        boolean[] visited = new boolean[number.length];

        list = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        combination(number, 0, sum, visited, 0);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            int result = 0;
            for (int j = 0; j < temp.size(); j++) {
                result += temp.get(j);
            }
            if(result == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void combination(int[] num, int idx, List<Integer> sum, boolean[] visited, int k) {
        if (idx == 3) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(sum);
            list.add(temp);
            return;
        }
        for (int i = k; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum.add(num[i]);
                combination(num, idx + 1, sum, visited, i + 1);
                sum.remove(sum.size() - 1);
                visited[i] = false;
            }
        }
    }
}
