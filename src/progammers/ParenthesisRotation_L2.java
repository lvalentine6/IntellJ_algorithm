package progammers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParenthesisRotation_L2 {
    static int cnt;

    public static void main(String[] args) {
        String s = "[)(]";
        int answer = 0;
        cnt = 0;

        // 올바른 괄호 검사 후 문자열 이동
        for (int i = 0; i < s.length() - 1; i++) {
            isCorrect(s);
            s = move(s);
        }

        answer = cnt;

        System.out.println(answer);

    }

    // 문자열을 이동하는 메서드
    static String move(String s) {
        Queue<Character> queue = new LinkedList<>();

        // Queue에 s 삽입
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        // 처음 문자 제거후 마지막에 추가
        char ch = queue.poll();
        queue.add(ch);

        // StringBuilder로 String 만들고 반환
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    // 올바른 괄호인지 확인하는 메서드
    static void isCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        // 괄호의 짝이 맞는지 확인
        // 대괄호 cnt
        int fCnt = 0;
        // 중괄호 cnt
        int sCnt = 0;
        // 소괄호 cnt
        int tCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                    fCnt++;
                    break;
                case ']':
                    fCnt--;
                    break;
                case '(':
                    sCnt++;
                    break;
                case ')':
                    sCnt--;
                    break;
                case '{':
                    tCnt++;
                    break;
                case '}':
                    tCnt--;
                    break;
            }
        }
        // 짝이 맞는다면 Stack에 넣고 짝이 맞으면 제거
        if (fCnt == 0 && sCnt == 0 && tCnt == 0) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if((stack.contains('[')) && s.charAt(i) == ']') {
                    stack.pop();
                } else if(s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else if ((stack.contains('(')) && s.charAt(i) == ')') {
                    stack.pop();
                } else if (s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else if((stack.contains('{')) && s.charAt(i) == '}') {
                    stack.pop();
                }
            }
            // Stack의 size가 0이면 조건 만족
            if(stack.size() == 0) {
                cnt++;
            }
        }
    }
}