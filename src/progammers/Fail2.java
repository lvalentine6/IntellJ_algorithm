package progammers;

import java.util.*;

public class Fail2 {
    public static void main(String[] args) {
       int n = 5;
       int[] stages = {2,1,2,6,2,4,3,3};
       int[] answer = {};

        Map<Integer, Double> list = new HashMap();
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if(i == stages[j]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
//            list.put(i, (double)cnt / s);
//            System.out.println(list);
        }
    }
}
