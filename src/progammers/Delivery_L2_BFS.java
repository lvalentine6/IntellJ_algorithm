package progammers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Delivery_L2_BFS {
    static List<ArrayList<Node>> list;
    static int cnt;

    public static void main(String[] args) {
        int n = 6;
        int k = 4;
//        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int answer = 0;

        // 자기 자신의 마을은 무조건 방문
        cnt = 1;

        // 인접 리스트
        list = new ArrayList<>();
        int[] visited = new int[n + 1];

        // 리스트 초기화
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 인전 리스트를 통해 Node에 값 입력
        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }

        // BFS 탐색
        bfs(n, k, visited);

        answer = cnt;

        System.out.println(answer);

    }

    // BFS 탐색 메서드
    static void bfs(int n, int k, int[] visited) {
        // 탐색을 위한 queue
        Queue<Node> queue = new LinkedList<>();

        // 방문 배열 최댓값으로 초기화
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        // 1번에서 갈수있는 마을 전부 추가
        queue.addAll(list.get(1));

        // BFS
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 방문 예정 마을이 이동거리의 합 보다 크거나 같지 않으면
            if (!(visited[node.b] <= visited[node.a] + node.l)) {
                visited[node.b] = visited[node.a] + node.l;
                queue.addAll(list.get(node.b));
            }
        }

        // 출력
        for (int i = 2; i < n + 1; i++) {
            if (visited[i] <= k) {
                cnt++;
            }
        }
    }

    // Node 클래스
    static class Node {
        int a, b, l;

        Node(int a, int b, int l) {
            this.a = a;
            this.b = b;
            this.l = l;
        }

        // 클래스 출력 메서드
        @Override
        public java.lang.String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    ", l=" + l +
                    '}';
        }
    }
}
