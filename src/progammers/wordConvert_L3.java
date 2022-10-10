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

        list = new ArrayList<>();

        boolean[] visited = new boolean[words.length];

        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) {
                flag = true;
                break;
            }
        }
        if(!flag) {
//            return answer;
        }

        dfs(begin, target, words, visited,0);

        answer = Collections.min(list);

        System.out.println(answer);
    }
    static void dfs(String begin, String target, String[] word, boolean[] visited, int cnt) {
        if(cnt != 0) {
            int temp = 0;
            for (int i = 0; i < word[0].length(); i++) {
                if(begin.charAt(i) != target.charAt(i)) {
                    temp++;
                }
            }
            if(temp == 1) {
                list.add(cnt + 1);
            }
        }

        for (int i = 0; i < word.length; i++) {
            int dif = 0;
            for (int j = 0; j < word[0].length(); j++) {
                if(begin.charAt(j) != word[i].charAt(j)) {
                    dif++;
                }
            }
            if(dif == 1 && !visited[i]) {
                visited[i] = true;
                dfs(word[i], target, word, visited, cnt + 1);
            }
        }
    }
}
