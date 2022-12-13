package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class englishWordChain_L2 {
    static List<String> list;

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = new int[2];

        // 단어를 저장하는 list
        list = new ArrayList<>();
        // 말한 횟수를 카운트하는 map
        Map<Integer, Integer> map = new HashMap<>();

        // map 초기화
        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }

        // 순서를 카운트하는 변수
        int order = 1;
        for (int i = 0; i < words.length; i++) {
            // 찻번째 단어일 경우
            if (i == 0) {
                list.add(words[i]);
                map.put(order, map.getOrDefault(order, 0) + 1);
                order++;
                continue;
            }

            // 순서가 n보다 커지면 1로 초기화
            if (order > n) {
                order = 1;
            }

            // 올바른 단어 체크 메서드 호출
            if (!check(words[i], i)) {
                map.put(order, map.getOrDefault(order, 0) + 1);
                answer[0] = order;
                answer[1] = map.get(order);
                break;
            }

            // 단어 list에 삽입
            list.add(words[i]);
            // 말한 횟수 카운트
            map.put(order, map.getOrDefault(order, 0) + 1);
            // 순서 증가
            order++;
        }
        System.out.println(Arrays.toString(answer));
    }

    // 올바른 단어인지 체크하는 메서드
    static boolean check(String s, int idx) {
        // 단어의 길이가 1보다 작다면
        if (s.length() >= 1) {
            return false;
        }

        // 이미 말한 단어가 있다면
        if (list.contains(s)) {
            return false;
        }

        // 이전 단어의 마지막과 현재 단어의 첫번째가 같은지 확인
        char temp = list.get(idx - 1).charAt(list.get(idx - 1).length() - 1);
        if (temp != s.charAt(0)) {
            return false;
        }

        // 올바른 단어일 경우
        return true;
    }
}
