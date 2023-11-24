package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fail {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 4, 2, 4, 3, 3};
        int[] answer = new int[N];

        // 배열 리스트로 옮기기
        List<Integer> list = new ArrayList();
        for (int i : stages) {
            list.add(i);
        }

        // 실패율을 구하기 위한 맵
        Map<Integer, Double> map = new HashMap();
        // 스테이지 개수만큼 반복
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            // 리스트의 사이즈
            int s = list.size();
            for (int j = 0; j < list.size(); j++) {
                if (i == list.get(j)) {
                    // 각 스테이지에 있는 플레이어 숫자 구하기
                    cnt = Collections.frequency(list, i);
                    // 계산된 플레이어 삭제
                    list.removeAll(Collections.singleton(list.get(j)));
                }
            }

            // 실패율 계산
            double fail = (double) cnt / s;

            // 0 / 0 예외처리
            if (cnt == 0 && s == 0) {
                fail = 0.0;
            }

            // 맵에 스테이지 정보와 실패율 추가
            map.put(i, fail);
        }

        // 맵을 값으로 내림차순 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        // 맵의 키값 정답으로 출력
        for (int i = 0; i < keyList.size(); i++) {
            answer[i] = keyList.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
