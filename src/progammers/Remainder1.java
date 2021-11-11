package progammers;

import java.util.TreeSet;

public class Remainder1 {
    public static void main(String[] args) {
        int n = 10;
        int answer = 0;

        // x를 넣을 treeset 초기화
        TreeSet<Integer> ts = new TreeSet<>();
        int x = 1;

        for (int i=0; i<n; i++) {
            if (n % x != 1) {
                x++;
            }else {
                ts.add(x);
                x++;
            }
        }

        answer = ts.pollFirst();
        System.out.println(answer);
    }
}
