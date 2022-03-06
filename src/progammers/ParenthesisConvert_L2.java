package progammers;

import java.util.Stack;

public class ParenthesisConvert_L2 {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        // 입력 문자열이 공백이면 공백반환
        if(p.equals("")) {
            return "";
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder(p);
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            if(sb.charAt(i) == '(') {
                cnt++;
            } else if(sb.charAt(i) == ')') {
                cnt--;
                // cnt가 0이라는건 (와 )의 짝이 맞는다는것
            } if(cnt == 0) {
                u.append(sb.substring(0, i+1));
                v.append(sb.substring(i+1));
                break;
            }
        }

        // 재귀 실행
        if(IsCorrect(u.toString())) {
            // 올바른 문자열이라면
            return u.append(solution(v.toString())).toString();
        }

        // 올바른 문자열이 아니면
        answer.append("(").append(solution(v.toString())).append(")");
        // 앞뒤 문자 제거
        u.deleteCharAt(0);
        u.deleteCharAt(u.length()-1);
        // 반환
        answer.append(switching(u.toString()));
        return answer.toString();
    }

    // 올바른 문자열인지 확인하는 메서드
    public static boolean IsCorrect (String p) {
        Stack<String> st = new Stack<>();
        // 스텍에 (만 넣어주고 )를 만나면 스텍에서 제거
        for (String i : p.split("")) {
            if(i.equals("(")) {
                st.push(i);
            } if(!st.isEmpty() && i.equals(")")) {
                st.pop();
            }
        }
        // 스텍의 사이즈가 0이면 올바른 문자열
        return st.size() == 0;
    }

    // 괄호를 뒤집는 메서드
    public static String switching(String u) {
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') {
                sbs.append(')');
            } else {
                sbs.append('(');
            }
        }
        return sbs.toString();
    }
}