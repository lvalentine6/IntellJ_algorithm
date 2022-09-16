package progammers;

import java.util.*;

public class compact_L2 {
    public static void main(String[] args) {
//        String msg = "KAKAO";
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        List<Integer> list = new ArrayList<>();

        // 사전을 담을 map 생성
        Map<String, Integer> map = new HashMap<>();

        // map 초기화
        int n = 1;
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(ch++), n++);
        }

        int start = 27;
        // 문자열 탐색
        roof : for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char w = msg.charAt(i);
            sb.append(w);
            int cnt = 1;

            while (map.containsKey(sb.toString())) {
                int idx = i + cnt;
                if (idx >= msg.length()) {
                    list.add(map.get(sb.toString()));
                    break roof;
                }
                sb.append(msg.charAt(idx));
                cnt++;
            }
            map.put(sb.toString(), start++);
            if (sb.length() > 2) {
                i += cnt - 2;
            }

            list.add(map.get(sb.delete(sb.length() - 1, sb.length()).toString()));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
