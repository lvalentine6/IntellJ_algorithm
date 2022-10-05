package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nightWork_L3 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {1,1};
        long answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < works.length; i++) {
            list.add(works[i]);
        }

        while (n > 0) {
            int idx = list.indexOf(Collections.max(list));
            if(list.get(idx) == 0) {
                break;
            }
            list.set(idx, list.get(idx) - 1);
            n--;
        }

        for (int i = 0; i < list.size(); i++) {
            answer += Math.pow(list.get(i), 2);
        }

        System.out.println(answer);

    }
}
