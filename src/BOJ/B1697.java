package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static int n, m, cnt;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bfs(n);
        System.out.println(cnt);
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        // n값 방문 처리
        visited[num] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            // n이 m과 같아지면
            if(temp == m) {
                cnt = visited[temp] - 1; return;
            }
            // 범위를 벗어나지 않고 방문한적이 없다면
            if (temp - 1 >= 0 && visited[temp - 1] == 0) {
                visited[temp - 1] = visited[temp] + 1;
                queue.offer(temp - 1);
            }
            if (temp + 1 <= 100000 && visited[temp + 1] == 0) {
                visited[temp + 1] = visited[temp] + 1;
                queue.offer(temp + 1);
            }
            if (temp * 2 <= 100000 && visited[temp * 2] == 0) {
                visited[temp * 2] = visited[temp] + 1;
                queue.offer(temp * 2);
            }
        }
    }
}
