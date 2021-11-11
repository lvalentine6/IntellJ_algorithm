package progammers;

import java.util.TreeSet;

public class Remainder1 {
    public static void main(String[] args) {
        int n = 10;
        int answer = 0;

        // x를 위한 list
        TreeSet<Integer> ts = new TreeSet<>();
        int num = 1;

        for (int i=0; i<n; i++) {
            if(n % num != 1) {
                num++;
            } else {
                ts.add(num);
                num++;
            }
        }

        answer = ts.pollFirst();
        System.out.println(answer);
    }
}
