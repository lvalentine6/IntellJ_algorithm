package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wordConvert_L3 {
    static List<Integer> list;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"cog", "log", "lot", "dog", "dot", "hot"};
        int answer = 0;

        // 단계를 저장할 리스트
        list = new ArrayList<>();
        // 방문 여부 배열
        boolean[] visited = new boolean[words.length];

        // target이 words 있는지 검사
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                flag = true;
                break;
            }
        }
        // target이 words 배열에 없다면 0 리턴
        if (!flag) {
//            return answer;
        }

        // dfs 탐색
        dfs(begin, target, words, visited, 0);

        // 리스트에서 최솟값이 정답
        answer = Collections.min(list);

        System.out.println(answer);
    }

    static void dfs(String begin, String target, String[] word, boolean[] visited, int cnt) {
        int temp = 0;
        // 현재 문자열과 target 문자열 비교
        for (int i = 0; i < word[0].length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                temp++;
            }
        }
        // 현재 문자열이 target 문자열과 한글자만 다르다면
        if (temp == 1) {
            // cnt값 리스트에 저장
            list.add(cnt + 1);
        }

        // words 배열을 순회하며 현재 문자열과 words의 문자열 비교
        for (int i = 0; i < word.length; i++) {
            int dif = 0;
            for (int j = 0; j < word[0].length(); j++) {
                if (begin.charAt(j) != word[i].charAt(j)) {
                    dif++;
                }
            }
            // 현재 문자열이 words 문자열과 한글자만 다르고 방문하지 않았다면
            if (dif == 1 && !visited[i]) {
                // 방문 처리
                visited[i] = true;
                // 재귀 호출
                dfs(word[i], target, word, visited, cnt + 1);
            }
        }
    }
}
