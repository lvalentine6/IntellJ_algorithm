package progammers;

import java.util.*;

public class twoQueue_L2 {
    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};

        int answer = 0;

        // 각 큐의 합
        long sumQ1 = 0;
        long sumQ2 = 0;

        // 두 큐의 합 구하고 각 큐 원소 리스트에 추가
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queue1.length; i++) {
            sumQ1 += queue1[i];
            sumQ2 += queue2[i];
            list.add(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            list.add(queue2[i]);
        }

        // 각 큐의 목표 합
        long target = (sumQ1 + sumQ2) / 2;
        // idx 설정을 위한 mid
        int mid = (queue1.length + queue2.length) / 2;
        int start = 0;
        int idx = 0;
        int idx2 = mid;

        while (!(sumQ1 == target)) {
            // idx의 범위가 list.size를 벗어나면 원소 합을 같게 만들수 없음
            if(idx2 >= list.size() || start >= list.size()) {
                answer = -1;
                break;
            }
            if (sumQ1 < sumQ2) {
                idx = idx2;
                sumQ2 -= list.get(idx);
                sumQ1 += list.get(idx);
                idx2++;
            } else {
                idx = start;
                sumQ1 -= list.get(idx);
                sumQ2 += list.get(idx);
                start++;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
