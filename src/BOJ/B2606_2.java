package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606_2 {
    static int arr[][];
    static boolean visit[];
    static int n, r;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());

        answer = 0;
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;
        // 큐가 비어 있다는것은 순회가 끝났다는것
        while (!queue.isEmpty()) {
            // i번부터 탐색
            int temp = queue.poll();
            for (int j = 1; j < n + 1; j++) {
                // 노드가 연결되어 있고 방문하지 않았다면
                if (arr[temp][j] == 1 && visit[j] == false) {
                    // 방문처리하고 큐에 넣기
                    visit[j] = true;
                    queue.offer(j);
                    answer++;
                }
            }
        }
    }
}
