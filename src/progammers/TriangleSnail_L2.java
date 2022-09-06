package progammers;

import java.util.*;

public class TriangleSnail_L2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int targetNum = 0;
        for (int i = 1; i <= n; i++) {
            targetNum += i;
        }

        search(arr, visited, targetNum,0, 0, 1, n);

        int[] answer = new int[targetNum];
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= idx; j++) {
                list.add(arr[i][j]);
            }
            idx++;
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }

    static void search(int[][] arr, boolean[][] visited, int target, int x, int y, int sum, int n) {
        int flag = 0;
        while (sum <= target) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                arr[x][y] = sum;
                sum++;
            }
            if(flag == 0) {
                if(x < n - 1) {
                    x++;
                } else {
                    flag = 1;
                }
            } else if (flag == 1) {
                if(y < n - 1) {
                    y++;
                } else {
                    flag = 2;
                }
            } else {
                if(!visited[x - 1][y - 1]) {
                    x--;
                    y--;
                } else {
                    flag = 0;
                }
            }

            System.out.println(Arrays.deepToString(arr));
        }
    }
}
