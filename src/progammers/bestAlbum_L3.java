package progammers;

import java.util.*;

public class bestAlbum_L3 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop" };
        int[] plays = {500, 600, 150, 800, 2500};
        List<Integer> result = new ArrayList<>();

        // 각 장르별로 HashMap에 넣기
        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // keySet을 value 기준으로 내림차순 정렬
        List<String> list = new ArrayList<>(genreMap.keySet());
        Collections.sort(list, (o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);

            // 첫번째로 많이 재생된 노래 찾기
            int firstMax = 0;
            int firstIdx = -1;

            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(s) && firstMax < plays[j]) {
                    firstMax = Math.max(firstMax, plays[j]);
                    firstIdx = j;
                }
            }

            // 두번째로 많이 재생된 노래 찾기
            int secondMax = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(s) && secondMax < plays[j] && j != firstIdx) {
                    secondMax = plays[j];
                    secondIdx = j;
                }
            }
            result.add(firstIdx);
            if (secondIdx >= 0) {
                result.add(secondIdx);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
