package progammers;

import org.w3c.dom.Node;

import java.util.*;

public class Delivery_L2_BFS {
    static List<ArrayList<Node>> list;
    static int cnt;
    public static void main(String[] args) {
        int n = 6;
        int k = 4;
//        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int answer = 0;
        cnt = 1;

        list = new ArrayList<>();
        int[] visited = new int[n + 1];

        // 리스트 초기화
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }

        System.out.println(list);

        bfs(n, k, visited);

        answer = cnt;

        System.out.println(cnt);

    }
    static void bfs(int n, int k, int[] visited) {
        // 탐색을 위한 queue
        Queue<Node> queue = new LinkedList<>();

        // 방문 배열 최댓값으로 초기화
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        queue.addAll(list.get(1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.a] <= visited[node.b] + node.l) {
                continue;
            }
            visited[node.a] = visited[node.b] + node.l;
            queue.addAll(list.get(node.a));
            System.out.println(Arrays.toString(visited));
        }

        for (int i = 2; i < n + 1; i++) {
            if(visited[i] <= k) {
                cnt++;
            }
        }
    }

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
