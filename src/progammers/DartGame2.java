package progammers;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame2 {
    public static void main(String[] args) {
        String dartResult = "1D#2S*3S";
        int answer = 0;

        // 1. 문자열을 하나씩 돌면서 계산
        // 2. 정규표현식으로 그룹별로 나누고 계산

        // 패턴 컴파일
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");

        // 컴파일된 패턴 검사
        Matcher matcher = pattern.matcher(dartResult);

        // 스텍을 이용해서 그룹별로 뽑기
        Stack<Integer> stk = new Stack<>();
        while(matcher.find()) {
            // 점수
            int num = Integer.parseInt(matcher.group(1));

            // 점수 곱하기
            if (matcher.group(2).equals("D")) {
                num *= num;
            }
            if (matcher.group(2).equals("T")) {
                num *= (num * num);
            }

            System.out.println(stk);
            // 스타상, 아차상
            if (matcher.group(3).equals("*")) {
                if(!stk.isEmpty()) {
                    int top = stk.pop();
                    stk.push(top * 2);
                }
                num *= 2;
            }
            if (matcher.group(3).equals("#")) {
                num *= -1;
            }
            stk.push(num);
        }
        while(!stk.isEmpty())
            answer += stk.pop();
        System.out.println(answer);
    }
}
