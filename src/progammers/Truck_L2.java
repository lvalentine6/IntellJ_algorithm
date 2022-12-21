package progammers;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_L2 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        // 다리 위 트럭 무게 총합
        int temp = 0;
        int i = 0;

        // 모든 트럭이 다리 위에 올라가도록 계속 반복
        while (true) {
            // 마지막 트럭이 다리에 올라가면
            if (i == truck_weights.length) {
                break;
            }
            // 트럭이 다리 끝에 도달하면 하면 다리 위 트럭 무게에서 빼기
            if (queue.size() == bridge_length) {
                temp -= queue.poll();
            }
            // 다리 위 트럭 무게 총합 + 다음 올라와야 하는 트럭 무게가 다리 하중보다 크면
            else if (temp + truck_weights[i] > weight) {
                // 먼저 올라간 트럭이 내려와야 하므로 0을 추가하고 1초 대기
                queue.add(0);
                answer++;
            } else {
                queue.add(truck_weights[i]);
                temp += truck_weights[i];
                i++;
                answer++;
            }
        }

        // 마지막 트럭이 다리위에 올라간 상태에서 다리 길이를 더하기
        answer = answer + bridge_length;

        System.out.println(answer);
    }
}
