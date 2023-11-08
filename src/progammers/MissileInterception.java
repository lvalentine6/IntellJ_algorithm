package progammers;

import java.util.Arrays;
import java.util.Comparator;

public class MissileInterception {
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        int answer = 0;
        int end = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for(int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if(s >= end) {
                end = e;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
