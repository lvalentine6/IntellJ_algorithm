package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2667 {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 정사각형
        arr = new int[n][n];
        // 총 단지수
        int answer = 0;
        // split으로 입력값을 자르고 int로 변환하여 인접행렬 생성
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        // cnt를 저장하기 위한 리스트
        ArrayList<Integer> list = new ArrayList<>();
        // 인접행렬에서 dfs 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    answer++;
                    list.add(cnt);
                }
            }
        }
        // cnt 정렬
        Collections.sort(list);
        System.out.println(answer);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 이동한 좌표가 범위를 벗어나면
            if (nx >= n || ny >= n || nx < 0 || ny < 0) {
                continue;
            }
            // 연결되어 있지 않다면
            if (arr[nx][ny] == 0) {
                continue;
            }
            // 탐색한 집은 0으로 바꾸기
            arr[x][y] = 0;
            // 다음음집을 0으로 바꾸고 재귀 호출
            arr[nx][ny] = 0;
            dfs(nx, ny);
            cnt++;
        }
    }
}
