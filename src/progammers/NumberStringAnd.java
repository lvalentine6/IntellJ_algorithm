package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberStringAnd {
    public static void main(String[] args) {
        String s = "2three45sixseven";
        int answer = 0;

        // answer로 변환하기 전 String 변수
        String sb = new String();
        // s를 배열로 변환후 리스트로 변환
        String[] temp = s.split("");
        List<String> list = new ArrayList<>(Arrays.asList(temp));

        // 문자열을 판단하기 위한 변수
        String a = new String();

        while(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                // a에 한글자씩 더해서 문자열 만들기
                a += list.get(0);
                // 사용한 문자 지우기
                list.remove(0);
                switch (a) {
                    case "zero":
                    case "0":
                        sb += 0;
                    a = ""; break;
                    case "one":
                    case "1":
                        sb += 1;
                    a = ""; break;
                    case "two":
                    case "2":
                        sb += 2;
                    a = ""; break;
                    case "three":
                    case "3":
                        sb += 3;
                    a = ""; break;
                    case "four":
                    case "4":
                        sb += 4;
                    a = ""; break;
                    case "five":
                    case "5":
                        sb += 5;
                    a = ""; break;
                    case "six":
                    case "6":
                        sb += 6;
                    a = ""; break;
                    case "seven":
                    case "7":
                        sb += 7;
                    a = ""; break;
                    case "eight":
                    case "8":
                        sb += 8;
                    a = ""; break;
                    case "nine":
                    case "9":
                        sb += 9;
                    a = ""; break;
                }
            }
        }
        answer = Integer.parseInt(sb);
        System.out.println(answer);


    }
}
