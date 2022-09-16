package progammers;

import java.util.*;

public class compact_L2 {
    public static void main(String[] args) {
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
                list.add(map.get(sb.toString()));
                int idx = i + cnt;
                if(idx >= msg.length()) {
                    break roof;
                }
                sb.append(msg.charAt(idx));
                cnt++;
            }
            map.put(sb.toString(), start++);
            if(sb.length() > 2) {
                i += cnt - 2;
                System.out.println(sb);
            }
        }

        System.out.println(list);
        System.out.println(map);
//        int[] answer = new int[5];
//        System.out.println(Arrays.toString(answer));
    }
}
