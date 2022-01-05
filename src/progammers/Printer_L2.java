package progammers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer_L2 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        // 내림차순으로 우선순위 큐 만들기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : priorities){
            pq.offer(n);
        }

        // 큐가 비어있지 않다면
        while(!pq.isEmpty()){
            // 큐에서 나오는 값과 매칭되는 경우를 탐색.
            for(int i = 0; i<priorities.length; i++){
                // 값만 일치하는 경우 해당 문서 출력.
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    // 값과 인덱스가 모두 일치하면 반환
                    if(location == i ); // return answer;
                }
            }
        }
        System.out.println(answer);
    }
}
