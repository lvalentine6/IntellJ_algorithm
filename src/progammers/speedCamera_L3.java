package progammers;

import java.util.Arrays;
import java.util.Comparator;

public class speedCamera_L3 {
    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, 13}, {-5, -3}};
        int answer = 0;

        // routes[1] 값을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int min = Integer.MIN_VALUE;

        // 탐색
        for (int i = 0; i < routes.length; i++) {
            if(routes[i][0] > min) {
                min = routes[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
