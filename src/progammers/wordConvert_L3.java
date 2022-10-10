package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wordConvert_L3 {
    static List<Integer> list;
    static List<Integer> temp;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = 0;

        list = new ArrayList<>();
        temp = new ArrayList<>();

        boolean[] visited = new boolean[words.length];

        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if(begin.equals(words[i])) {
                flag = true;
                break;
            }
        }
        if(!flag) {
//            return answer;
        }

        dfs(begin, target, words, visited,0);

        System.out.println(list);
    }
    static void dfs(String begin, String target, String[] word, boolean[] visited, int cnt) {
        temp.clear();
//        if(begin.equals(target)) {
//            list.add(cnt);
//            return;
//        }

        for (int i = 0; i < word.length; i++) {
            int dif = 0;
            for (int j = 0; j < word[0].length(); j++) {
                if(begin.charAt(j) != word[i].charAt(j)) {
                    dif++;
                }
            }
            temp.add(dif);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) != 0 && temp.get(i) < min) {
                min = temp.get(i);
            }
        }
        System.out.println(min);

        for (int i = 0; i < temp.size(); i++) {
            if(begin.equals(target)) {
                list.add(cnt);
                return;
            }
            if(temp.get(i) == min && !visited[i]) {
                visited[i] = true;
                dfs(word[i], target, word, visited,cnt + 1);
            }
        }
    }
}
