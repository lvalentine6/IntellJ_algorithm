package progammers.preTest;

import java.util.*;

public class Test1 {
    static boolean[] visitedCom;
    static long max;
    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        String answer = "";

        List<Character> list = new ArrayList<>();
        boolean[] visited = new boolean[Y.length()];

        for (int i = 0; i < X.length(); i++) {
            for (int j = 0; j < Y.length(); j++) {
                if(!visited[j] && (X.charAt(i) == Y.charAt(j))) {
                    visited[j] = true;
                    list.add(Y.charAt(j));
                }
            }
        }
        List<Character> listX = new ArrayList<>();
        List<Character> listY = new ArrayList<>();

        for (int i = 0; i < X.length(); i++) {
            listX.add(X.charAt(i));
        }

        for (int i = 0; i < Y.length(); i++) {
            listY.add(Y.charAt(i));
        }

        listX.retainAll(listY);
        System.out.println(listX);

        if(list.isEmpty()) {
            answer = "-1";
        }

        Collections.sort(list, Collections.reverseOrder());

        if(list.get(0) == '0') {
            answer = "0";
        }
//        boolean flag = false;
//        for (char c : list) {
//            if(c != '0') {
//                flag = true;
//            }
//        }
//
//        if(!flag) {
//            answer = "0";
//        }
//        visitedCom = new boolean[list.size()];
//        max = 0;
//        String str = "";
//        com(list, str, 0);

//        answer = String.valueOf(max);
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        answer = sb.toString();
        System.out.println(answer);
    }
//    static void com(List<Character> list, String str, int cnt) {
//        if(cnt == list.size()) {
//            max = Math.max(Long.parseLong(str),max);
//            return;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            if(!visitedCom[i]) {
//                visitedCom[i] = true;
//                com(list, str + list.get(i), cnt + 1);
//                visitedCom[i] = false;
//            }
//        }
//    }
}
