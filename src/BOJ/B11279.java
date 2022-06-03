package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 우선순위 큐 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if(v != 0) {
                pq.offer(v);
            } else {
                if(pq.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.peek()).append("\n");
                    pq.poll();
                }
            }
        }
        System.out.println(sb);
    }
}
