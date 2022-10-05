package progammers;

import java.util.Arrays;

public class nightWork_L3 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {1, 1};
        long answer = 0;

        int idx = 0;
        int cnt = 0;
        while (n > 0) {
            if (idx > works.length - 1) {
                idx = 0;
            }
            if(cnt == works.length) {
                break;
            }
            if (works[idx] == 0) {
                cnt++;
                continue;
            }
            works[idx]--;
            n--;
            idx++;
        }

        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(works[i], 2);
        }

        System.out.println(Arrays.toString(works));
        System.out.println(answer);

    }
}
