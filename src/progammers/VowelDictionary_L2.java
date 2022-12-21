package progammers;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary_L2 {
    static String[] arr;
    static List<String> list;

    public static void main(String[] args) {
        String word = "AAAE";
        int answer = 0;

        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};

        // 완전탐색
        recursion(word, "", 0);

        // list에서 word 찾기
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    // 완전탐색 메서드
    static void recursion(String word, String str, int depth) {
        list.add(str);
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}
