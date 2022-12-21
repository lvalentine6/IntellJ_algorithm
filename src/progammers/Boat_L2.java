package progammers;

import java.util.Arrays;

public class Boat_L2 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        // 무거운 사람과 가벼운 사람을 분류하기 위한 정렬
        Arrays.sort(people);
        int idx = 0;

        // 최소로 구명보드를 사용하려면 가장 무거운 사람과 가장 가벼운 사람
        for (int i = people.length - 1; i >= idx; i--) {
            // 무거운 사람 + 가벼운 사람이 리미트 보다 크면
            if (people[i] + people[idx] > limit) {
                answer++;
            }
            // 같거나 작은 경우
            else {
                idx++;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
