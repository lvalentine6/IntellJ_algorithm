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
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if ((stack.contains('[')) && s.charAt(i) == ']') {
                    stack.pop();
                } else if ((stack.contains('(')) && s.charAt(i) == ')') {
                    stack.pop();
                } else if ((stack.contains('{')) && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            }
        }
        // Stack의 size가 0이면 조건 만족
        if (stack.size() == 0) {
            cnt++;
        }
    }
}