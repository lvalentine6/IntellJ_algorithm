package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B5430 {
    public static void main(String[] args) throws Exception {
        // 수행 시간 검사
//        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //입력값 배열 저장 ("error" 출력시 continue 하기위해 for문에 roof 별칭 부여)
        roof : for (int i = 0; i < t; i++) {
            Deque<Integer> deque = new LinkedList<>();
            String[] s = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            // 입력값 deque 저장
            for (int j = 0; j < size; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            // 검사
            boolean check = true;
            for (int j = 0; j < s.length; j++) {
                // deque의 접근 방향을 바꾼다
                if (s[j].equals("R")) {
                    check = !check;
                    continue;
                }
                // "D"이면서 check가 true 일 때
                if (check) {
                    if (deque.size() == 0) {
                        sb.append("error").append("\n");
                        continue roof;
                    } else {
                        deque.poll();
                    }
                    // check가 false 일 때
                } else {
                    if (deque.size() == 0) {
                        sb.append("error").append("\n");
                        continue roof;
                    } else {
                        deque.pollLast();
                    }
                }
            }

            // StringBuilder를 이용해서 출력문 만들기
            sb.append("[");
            if (deque.size() > 0) {
                if (check) {
                    sb.append(deque.pollFirst());
                    while (!deque.isEmpty()) {
                        sb.append(",").append(deque.pollFirst());
                    }
                } else {
                    sb.append(deque.pollLast());
                    while (!deque.isEmpty()) {
                        sb.append(",").append(deque.pollLast());
                    }
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
//        System.out.println((System.currentTimeMillis() - start) / 1000.0);
    }
}
