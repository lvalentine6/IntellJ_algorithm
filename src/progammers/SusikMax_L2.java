package progammers;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SusikMax_L2 {
    public static void main(String[] args) throws ScriptException {
//        String expression = "100-200*300-500+20";
        String expression = "50*6-3*2";
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        LinkedList<String> list = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        String[][] arr = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}};
        for (int j = 0; j < arr.length; j++) {
            LinkedList<String> listTemp = new LinkedList<>(list);
            while (listTemp.size() != 1) {
                for (int k = 0; k < arr[k].length; k++) {
                    for (int i = 0; i < listTemp.size(); i++) {
                        if (listTemp.get(i).equals(arr[j][k])) {
                            String midString = mid(listTemp.get(i - 1), listTemp.get(i), listTemp.get(i + 1));
                            listTemp.set(i - 1, midString);
                            listTemp.remove(i);
                            listTemp.remove(i);
                        }
                    }
                }
            }
            resultList.add(Math.abs(Integer.parseInt(listTemp.get(0))));
        }
        answer = Collections.max(resultList);
        System.out.println(answer);
    }

    static String mid(String s1, String s2, String s3) {
        int temp = 0;
        if (s2.equals("+")) {
            temp += Integer.parseInt(s1) + Integer.parseInt(s3);
        } else if (s2.equals("-")) {
            temp += Integer.parseInt(s1) - Integer.parseInt(s3);
        } else {
            temp += Integer.parseInt(s1) * Integer.parseInt(s3);
        }
        return String.valueOf(temp);
    }
}
