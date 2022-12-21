package progammers;

import java.util.ArrayList;

public class News_L2 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        int answer = 0;

        // 1. 두글자씩 끊기
        // 1-1 소문자열로 통일
        // 1-2 공백, 특수문자가 들어간 문자열 버리기
        // 2. 교집합과 합집합 구하기
        // 3. 자카드유사도 구하기
        // 4. 65536을 곱하고 정수부만 출력

        // 소문자열 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 집합 리스트
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // 공집합과 합집합 리스트
        ArrayList<String> g = new ArrayList<>();
        ArrayList<String> h = new ArrayList<>();

        // str1 문자열 두 문자씩 끊고 공백과 특수문자가 들어간 문자열 버리기
        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if ((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) {
                list1.add(String.valueOf(ch1) + String.valueOf(ch2));
            }
        }

        // str2 문자열 두 문자씩 끊고 공백과 특수문자가 들어간 문자열 버리기
        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if ((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) {
                list2.add(String.valueOf(ch1) + String.valueOf(ch2));
            }
        }

        // 교집합과 합집합
        for (String s : list1) {
            if (list2.remove(s)) {
                g.add(s);
            }
            h.add(s);
        }
        // h와 남아있는 list2 합집합
        h.addAll(list2);

        // 자카드 유사도 구하기
        double temp = (double) g.size() / (double) h.size();
        temp = temp * 65536;
        // 합집합이 공집합이면 자카드 유사도가 1이므로
        if (h.size() == 0) {
            System.out.println(65536);
        }
        answer = (int) temp;

        System.out.println(answer);
    }
}
