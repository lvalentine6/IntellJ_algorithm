package progammers;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        Arrays.sort(people);
        int idx = 0;

        for (int i = people.length - 1; i >= idx; i--) {
            if(people[i] + people[idx] > limit) {
                answer++;
            }
            else {
                idx++;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
