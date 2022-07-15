package progammers;


import java.util.*;

// 점수를 기준으로 이진 탐색을 이용하자
// 이진탐색을 이용하려면 정렬을 해야함
public class RankSearch_L2_2 {

    static HashMap<String, ArrayList<Integer>> hm;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer = new int[query.length];

        // 문자열과 점수를 담을 HashMap
        hm = new HashMap<>();

        // info로 모든 조합 만들기
        for (int i = 0; i < info.length; i++) {
            String[] infoTemp = info[i].split(" ");
            combination(infoTemp, "", 0);
        }

        // 이진 탐색을 위한 hm.values 정렬
        for (ArrayList<Integer> value : hm.values()) {
            Collections.sort(value);
        }

        // query 배열 수정
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" (and) ", "");
            String[] queryTemp = query[i].split(" ");
            // 이진 탐색 후 answer 배열에 값 삽입
            answer[i] = hm.containsKey(queryTemp[0]) ? binarySearch(queryTemp[0], Integer.parseInt(queryTemp[1])) : 0;
        }

        System.out.println(Arrays.toString(answer));
    }

    // 조합 메서드
    static void combination(String[] s, String str, int cnt) {
        // 조합이 완성되면
        if (cnt == 4) {
            if (!hm.containsKey(str)) {
                hm.put(str, new ArrayList<>());
            }
            hm.get(str).add(Integer.parseInt(s[4]));
            return;
        }
        combination(s, str + "-", cnt + 1);
        combination(s, str + s[cnt], cnt + 1);
    }

    // 이진 탐색 메서드
    static int binarySearch(String key, int score) {
        ArrayList<Integer> list = hm.get(key);
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list.size() - left;
    }
}
