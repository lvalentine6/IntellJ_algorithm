package progammers;

import java.util.*;

public class compact_L2 {
    public static void main(String[] args) {
//        String msg = "KAKAO";
        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        // 결과를 담을 list
        List<Integer> list = new ArrayList<>();

        // 사전을 담을 map 생성
        Map<String, Integer> map = new HashMap<>();

        // map 초기화
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(ch++), i + 1);
        }

        // 사전 번호
        int idx = 27;

        for (int i = 0; i < msg.length(); i++) {
            String s = "";
            // i번째 글자 추가
            s += msg.charAt(i);
            // i + 1 글자 추가
            for (int j = i + 1; j < msg.length(); j++) {
                // 추가한 글자가 사전에 없다면
                if (!map.containsKey(s + msg.charAt(j))) {
                    // 사전에 추가하고 탐색 중단
                    map.put(s + msg.charAt(j), idx++);
                    break;
                    // 사전에 있다면 없을때까지 한 글자씩 추가
                } else {
                    s += msg.charAt(j);
                }
            }
            // 인덱스 조정
            i += s.length() - 1;
            // 번호 리스트에 저장
            list.add(map.get(s));
        }

        // list를 배열에 복사
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
