package progammers;

import java.util.LinkedList;

public class Cache_L2 {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int answer = 0;

        // cities 값을 소문자로 변환
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            // 캐시의 사이즈가 0인것 고려
            if(list.size() > cacheSize) {
                list.removeLast();
            }
            if(list.contains(cities[i])) {
                // list에 값이 있다면 삭제하고 제일 앞으로 추가
                list.remove(list.indexOf(cities[i]));
                answer++;
            } else {
                answer+=5;
            }
            list.addFirst(cities[i]);
        }
        System.out.println(answer);
    }
}
