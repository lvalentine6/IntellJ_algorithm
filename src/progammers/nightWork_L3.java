package progammers;

import java.util.*;

public class nightWork_L3 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {1, 1};
        long answer = 0;

        while (n > 0) {
            Arrays.sort(works);
            int idx = works.length - 1;
            if(works[idx] == 0) {
                break;
            }
            works[idx]--;
            n--;
        }

        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(works[i], 2);
        }

        System.out.println(answer);

    }
}
