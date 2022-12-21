package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2606 {
    static int arr[][];
    static boolean visit[];
    static int n, r;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());

        // 바이러스에 걸리는 컴퓨터 수
        answer = 0;
        // 탐색 경로 배열 (1부터 n까지 각각 연결된 노드배열)
        arr = new int[n + 1][n + 1];
        // 방문한 노드인지 확인
        visit = new boolean[n + 1];
        // 탐색 경로 배열
        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1-2 나 2-1 똑같음. 연결된 노드라면 1로 설정
            arr[a][b] = arr[b][a] = 1;
        }
        // dfs 실행
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int i) {
        visit[i] = true;
        for (int j = 1; j < n + 1; j++) {
            // 연결된 노드를 발견하고 방문한적이 없다면
            if(arr[i][j] == 1 && visit[j] == false) {
                // answer를 증가시키고 재귀를 통해 depth 증가
                answer++;
                dfs(j);
            }
        }
    }
}
