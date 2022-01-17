package progammers;

import java.util.HashMap;

public class Conceal_L2 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        // 곱셉을 위해 1로 초기화
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // 옷 종류별로 map에 넣기
        for (int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 의상 조합 (A와 B를 조합하는 경우의 수)
        for(String key : map.keySet()) {
            answer *= map.get(key)+1;
        }

        // 아무것도 안입었을 경우 제거
        answer--;

        System.out.println(answer);

    }
}
