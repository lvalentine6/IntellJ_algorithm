package progammers;

import java.util.Arrays;

public class WeirdStringMake2 {
    public static void main(String[] args) {
        String s = "try hello world";
        String answer = "";

        // 공백 감지를 위한 cnt 생성
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        // 문자열 자르기
        String[] temp = s.split("");

        // cnt를 이용해서 대소문자 바꾸기
        for (int i=0; i< temp.length; i++) {
        if(temp[i].equals(" ")) {
            cnt = 0;
        } else if(cnt % 2 == 0){
            temp[i] = temp[i].toUpperCase();
            cnt++;
        } else {
            temp[i] = temp[i].toLowerCase();
            cnt++;
            }
        // Stringbuilder로 문자열 만들기
        sb.append(temp[i]);
        }

        answer = sb.toString();

        System.out.println(answer);
        System.out.println(s);
        System.out.println(Arrays.toString(temp));
    }
}
