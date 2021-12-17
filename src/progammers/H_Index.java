package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {0, 0, 1, 1};
        int answer = 0;
        int h = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= citations.length; i++) {
            int up = 0;
            int down = 0;
            for (int j = 0; j < citations.length; j++) {
                if(citations[j] >= h) {
                    up++;
                }
                if(citations[j] <= h) {
                    down++;
                }
            }
            if (h <= up) {
                list.add(h);
            }
            h++;
        }
        answer = Collections.max(list);
        System.out.println(list);
        System.out.println(answer);
    }
}
