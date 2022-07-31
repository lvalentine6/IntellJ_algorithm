package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // 인접 리스트 만들기
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList());
        }

        // 입력값으로 인접 리스트 삽입
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            list.get(left).add(right);
            list.get(right).add(left);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i : list.get(temp)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = temp;
                }
            }
        }

        // 출력
        for (int i = 0; i < parent.length; i++) {
            if ((parent[i] != 0)) {
                if (i == parent.length - 1) {
                    sb.append(parent[i]);
                } else {
                    sb.append(parent[i]).append("\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
