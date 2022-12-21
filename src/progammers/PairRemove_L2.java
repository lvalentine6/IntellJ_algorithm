package progammers;

import java.util.Stack;

public class PairRemove_L2 {
    public static void main(String[] args) {
        String s = "cdcd";
        int answer = 0;

        // 캐릭터로 스택 선언
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 스택이 비어있지 않으면서 스택의 첫번째가 char와 같으면
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();
            } else {
                st.add(ch);
            }
        }

        // 스택이 비어 있다면 제거할수 있으므로 1 리턴
        if (st.isEmpty()) {
            answer = 1;
        }

        System.out.println(answer);

    }
}
