package progammers;

import java.util.ArrayList;

public class News_L2 {
    public static void main(String[] args) {
        String str1 = "FRAN C+E";
        String str2 = "french";
        int answer = 0;

        // 1. 두글자씩 끊기
        // 1-1 소문자열로 통일
        // 1-2 공백, 특수문자 버리기
        // 2. 문자열 비교
        // 3. 자카드유사도 구하기
        // 4. 65536을 곱하고 정수부만 출력

        // 공백, 특수문자 제거, 소문자열 변환
        str1 = str1.replaceAll("\\W", "").toLowerCase();
        str2 = str2.replaceAll("\\W", "").toLowerCase();

//        String[] list1 = new String[str1.length()-1];
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // str1 문자열 두 문자씩 끊기
        for (int i = 0; i < str1.length()-1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            list1.add(String.valueOf(ch1) + String.valueOf(ch2));
        }

        // str2 문자열 두 문자씩 끊기
        for (int i = 0; i < str2.length()-1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            list2.add(String.valueOf(ch1) + String.valueOf(ch2));
        }

        ArrayList<String> g = new ArrayList<>();
        ArrayList<String> h = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list1.get(i).equals(list2.get(j))) {
                    g.add(list1.get(i));
                } else {
                    if (!h.contains(list1.get(i))) {
                        h.add(list1.get(i));
                    }
                    if(!h.contains(list2.get(j))) {
                        h.add(list2.get(j));
                    }
                }
            }
        }

        double temp = (double)g.size() / (double)h.size();
        temp = temp * 65536;
        answer = (int)temp;

        System.out.println(answer);
        System.out.println(temp);
        System.out.println(g);
        System.out.println(h);
        System.out.println(list1);
        System.out.println(list2);
//        System.out.println(Arrays.toString(list1));
        System.out.println(str1);
        System.out.println(str2);

    }
}
