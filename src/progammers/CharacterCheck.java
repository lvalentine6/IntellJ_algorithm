package progammers;

import java.util.*;

public class CharacterCheck {
    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        // 각 지표별 배열 생성
        String[] character = {"RT", "CF", "JM", "AN"};

        // 리스트 안에 Map 선언
        List<Map<Character, Integer>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 지표별 특성 Map 삽입
        for (int i = 1; i <= 4; i++) {
            Map<Character, Integer> subMap = new HashMap<>();
            subMap.put(character[i-1].charAt(0), 0);
            subMap.put(character[i-1].charAt(1), 0);
            list.add(subMap);
        }

        // survey 요소를 돌며 점수 판별
        for (int i = 0; i < survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            // 점수를 위한 변수
            int num = 0;
            // 1~3점 이면
            if(choices[i] < 4) {
                switch (choices[i]) {
                    case 1 : num = 3;
                    break;
                    case 2 : num = 2;
                    break;
                    case 3 : num = 1;
                    break;
                }
                // 각 유형에 맞는 점수 Map에 삽입
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j).get(c1) != null) {
                        list.get(j).put(c1, list.get(j).getOrDefault(c1, 0) + num);
                    }
                }
                // 5~7점 이면
            } else if(choices[i] > 4) {
                switch (choices[i]) {
                    case 5 : num = 1;
                    break;
                    case 6 : num = 2;
                    break;
                    case 7 : num = 3;
                    break;
                }
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j).get(c2) != null) {
                        list.get(j).put(c2, list.get(j).getOrDefault(c2, 0) + num);
                    }
                }
            }
        }

        // Map에서 더 큰 성격 유형을 sb에 추가
        // 같은 점수면 첫번째 값을 추가
        for (int i = 0; i < list.size(); i++) {
            Set<Character> set = list.get(i).keySet();
            Object[] ch = set.toArray();
            if(list.get(i).get(ch[0]) >= list.get(i).get(ch[1])) {
                sb.append(ch[0]);
            } else{
                sb.append(ch[1]);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        String answer = sb.toString();
        System.out.println(answer);
    }
}
