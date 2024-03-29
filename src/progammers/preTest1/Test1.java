package progammers.preTest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 풀이시간 : 3시간
public class Test1 {
    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        String answer = "";

        List<Character> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        List<Character> listResult = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < X.length(); i++) {
            list.add(X.charAt(i));
            set.add(X.charAt(i));
        }

        for (int i = 0; i < Y.length(); i++) {
            list2.add(Y.charAt(i));
        }

        set.retainAll(list2);

        for (char c : set) {
            int cntX = 0;
            int cntY = 0;
            for (int i = 0; i < list.size(); i++) {
                if (c == list.get(i)) {
                    cntX++;
                }
            }
            for (int i = 0; i < list2.size(); i++) {
                if (c == list2.get(i)) {
                    cntY++;
                }
            }
            int min = Math.min(cntX, cntY);

            for (int i = 0; i < min; i++) {
                listResult.add(c);
            }
        }

        if (listResult.isEmpty()) {
            answer = "-1";
//            return answer;
        }

        Collections.sort(listResult, Collections.reverseOrder());

        if (listResult.get(0) == '0') {
            answer = "0";
//            return answer;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : listResult) {
            sb.append(c);
        }
        answer = sb.toString();
        System.out.println(answer);
    }
}
