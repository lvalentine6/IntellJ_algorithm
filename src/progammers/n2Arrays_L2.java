package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2Arrays_L2 {
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        long leftIdx = left / n;
        long leftRest = left % n;
        long rightIdx = right / n;
        long rightRest = right % n;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                int cnt = 1;
                for (int j = 0; j < n; j++) {
                    list.add(cnt++);
                }
            } else {
                int temp = i + 1;
                for (int j = 0; j < temp; j++) {
                    list.add(temp);
                }
                if (temp < n) {
                    int temp2 = 1;
                    for (int j = temp; j < n; j++) {
                        list.add(temp + temp2++);
                    }
                }
            }

            if (i == leftIdx) {
                for (int j = (int) leftRest; j < list.size(); j++) {
                    result.add(list.get(j));
                }
            } else if(i > leftIdx && i < rightIdx) {
                for (int j = 0; j < list.size(); j++) {
                    result.add(list.get(j));
                }
            } else if(i == rightIdx) {
                for (int j = 0; j <= rightRest; j++) {
                    result.add(list.get(j));
                }
            }
            System.out.println(list);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
