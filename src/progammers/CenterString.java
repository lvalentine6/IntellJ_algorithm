package progammers;

import java.util.Arrays;

public class CenterString {
    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";
        String answer = "";

        // 문자열 나누기
        String[] temp = new String[s.length()];
        temp = s.split("");

        // 중간값 구하기 (배열순서 보정)

        // 단어 길이가 짝수일때
        if (s.length() % 2 == 0) {
            int tempint = s.length() / 2 - 1;
            int tempint2 = s.length() / 2;
            answer = temp[tempint] + temp[tempint2];
        }

        // 단어 길이가 홀수일때
        else {
            double tempdouble = Math.ceil((double) s.length() / 2) - 1;
            answer = temp[(int) tempdouble];
        }

        System.out.println(answer);
        System.out.println(Arrays.toString(temp));
    }
}
