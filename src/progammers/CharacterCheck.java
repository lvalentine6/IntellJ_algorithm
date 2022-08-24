package progammers;

import java.util.*;

public class CharacterCheck {
    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        StringBuilder sb = new StringBuilder();
        String[] character = {"RT", "CF", "JM", "AN"};
        List<Map<Character, Integer>> list = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            Map<Character, Integer> subMap = new HashMap<>();
            subMap.put(character[i-1].charAt(0), 0);
            subMap.put(character[i-1].charAt(1), 0);
            list.add(subMap);
        }

        for (int i = 0; i < survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            int num = 0;
            if(choices[i] > 0 && choices[i] < 4) {
                switch (choices[i]) {
                    case 1 : num = 3;
                    break;
                    case 2 : num = 2;
                    break;
                    case 3 : num = 1;
                    break;
                }
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j).get(c1) != null) {
                        list.get(j).put(c1, list.get(j).getOrDefault(c1, 0) + num);
                    }
                }
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

        for (int i = 0; i < list.size(); i++) {
            Set<Character> set = list.get(i).keySet();
            Object[] ch = set.toArray();
            if(list.get(i).get(ch[0]) >= list.get(i).get(ch[1])) {
                sb.append(ch[0]);
            } else if (list.get(i).get(ch[0]) < list.get(i).get(ch[1])) {
                sb.append(ch[1]);
            }
        }

        String answer = sb.toString();
        System.out.println(list);
        System.out.println(answer);
    }
}
