package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSnail_L2 {
    public static void main(String[] args) {
        int n = 5;

        // n * n 배열 생성
        int[][] arr = new int[n][n];
        // 방문여부를 확인하기 위한 배열
        boolean[][] visited = new boolean[n][n];

        // 목표 값 (1+2+3...+n)
        int targetNum = 0;
        for (int i = 1; i <= n; i++) {
            targetNum += i;
        }

        // 탐색 메서드 호출
        search(arr, visited, targetNum, 0, 0, 1, n);

        int[] answer = new int[targetNum];
        List<Integer> list = new ArrayList<>();

        // 배열을 돌며 idx 까지 list에 추가
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= idx; j++) {
                list.add(arr[i][j]);
            }
            idx++;
        }

        // 리스트 값 배열에 담기
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }

    // 탐색 메서드
    static void search(int[][] arr, boolean[][] visited, int target, int x, int y, int sum, int n) {
        // 연산을 위한 변수
        int flag = 0;

        while (sum <= target) {
            // 방문하지 않았다면
            if (!visited[x][y]) {
                visited[x][y] = true;
                arr[x][y] = sum;
                sum++;
            }

            // flag == 0 이면 x값 증가
            if (flag == 0) {
                // 배열의 범위를 벗어나지 않으면서 방문하지 않았다면
                if ((x < n - 1) && (!visited[x + 1][y])) {
                    x++;
                } else {
                    flag = 1;
                }
                // flag == 1 이면 y값 증가
            } else if (flag == 1) {
                // 배열의 범위를 벗어나지 않으면서 방문하지 않았다면
                if ((y < n - 1) && (!visited[x][y + 1])) {
                    y++;
                } else {
                    flag = 2;
                }
                // flag == 2 이면 x, y값 감소
            } else {
                // 방문하지 않았다면
                if (!visited[x - 1][y - 1]) {
                    x--;
                    y--;
                } else {
                    flag = 0;
                }
            }
        }
    }
}
