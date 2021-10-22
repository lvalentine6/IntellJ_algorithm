package progammers;

import java.util.Arrays;

public class CaesarCipher {
    public static void main(String[] args) {
        String s = "a B Z";
        int n = 4;
        String answer = "";

        StringBuilder sb = new StringBuilder();

        // char 배열 생성후 문자 비교
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)) {
                // 소문자 26으로 나눈 나머지를 통해 순환 구현
                ch = (char)((ch - 'a' + n) % 26 + 'a');
            }
            else if(Character.isUpperCase(ch)) {
                // 대문자 26으로 나눈 나머지를 통해 순환 구현
                ch = (char)((ch - 'A' + n) % 26 + 'A');
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
