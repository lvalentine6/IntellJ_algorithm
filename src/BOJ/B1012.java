package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    static int m;
    static int n;
    // x, y 의 상하좌우 설정
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int answer = 0;
            
            // 탐색할 인접 행렬 구하기
            arr = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            // 인접 행렬을 탐색하며 dfs 시행
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(arr[j][l] == 1) {
                        dfs(j ,l);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            // 상하좌우로 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 탐색 범위를 벗어나면 통과
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            // 탐색한곳에 배추가 없다면 통과
            if(arr[nx][ny] == 0) {
                continue;
            }
            // 배추가 있다면 0으로 바꾸고 재귀 탐색
            arr[nx][ny] = 0;
            dfs(nx, ny);
        }
    }
}
