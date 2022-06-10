package progammers;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SusikMax_L2 {
    public static void main(String[] args) throws ScriptException {
        String expression = "100-200*300-500+20";
        long answer = 0;
        // 분리한 문자열을 담을 리스트
        LinkedList<String> list = new LinkedList<>();
        // 최종 연산 결과를 담을 리스트
        ArrayList<Long> resultList = new ArrayList<>();
        // StringTokenizer를 이용하여 문자열을 숫자와 연산자로 분리
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        // 모든 연산자 배열
        String[][] arr = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}};

        for (int j = 0; j < arr.length; j++) {
            // 분리한 문자열을 복사
            LinkedList<String> listTemp = new LinkedList<>(list);
            for (int k = 0; k < arr[k].length; k++) {
                for (int i = 0; i < listTemp.size(); i++) {
                    // 일치하는 연산자가 나온다면
                    if (listTemp.get(i).equals(arr[j][k])) {
                        // 중간 계산
                        String midString = mid(listTemp.get(i - 1), listTemp.get(i), listTemp.get(i + 1));
                        // 숫자 연산자 숫자 중 첫번째에 반환값으로 바꾸고 나머지 삭제
                        listTemp.set(i - 1, midString);
                        listTemp.remove(i);
                        listTemp.remove(i);
                        // 삭제로 인해 3개가 1개로 바뀌므로 i의 값 -2
                        i-=2;
                    }
                }
            }
            // 연산자 배열의 연산이 종료될때마다 결과 리스트에 추가
            resultList.add(Math.abs(Long.parseLong(listTemp.get(0))));
        }
        // 결과 리스트중 최댓값을 출력
        answer = Collections.max(resultList);
        System.out.println(answer);
    }

    // 중간 계산을 위한 메서드
    static String mid(String s1, String s2, String s3) {
        long temp = 0;
        if (s2.equals("+")) {
            temp += Long.parseLong(s1) + Long.parseLong(s3);
        } else if (s2.equals("-")) {
            temp += Long.parseLong(s1) - Long.parseLong(s3);
        } else {
            temp += Long.parseLong(s1) * Long.parseLong(s3);
        }
        return String.valueOf(temp);
    }
}
