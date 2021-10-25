package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringSort {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();

        // 리스트 맨 앞에 n번째 문자열 붙이기
        for (int i=0; i<strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        // 리스트 정렬
        Collections.sort(list);

        // 첫번째 문자 자르고 반환
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).substring(1, list.get(i).length());
        }

        System.out.println(Arrays.toString(answer));
    }
}
