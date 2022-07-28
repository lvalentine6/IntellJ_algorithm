package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 스택에 문자 하나씩 삽입
       for (int i = 0; i < s.length(); i++) {
           stack.push(s.charAt(i));

           // 스택의 길이가 폭탄보과 같거나 크면 탐색
           if(stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for(char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
