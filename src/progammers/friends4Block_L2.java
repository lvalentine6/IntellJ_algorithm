package progammers;

import java.util.*;

public class friends4Block_L2 {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static List<int[]> list;
    static int answer;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        answer = 0;

        // 2차원 배열로 변경
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].split("");
        }

        list = new ArrayList<>();

        while (true) {
            search(arr, m, n);
            if (!list.isEmpty()) {
                remove(arr);
                pull(arr);
            }
            break;
        }

        for (int[] i : list) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println(answer);
    }

    static void search(String[][] arr, int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                String target = arr[i][j];
                int cnt = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (target.equals(arr[nx][ny])) {
                        cnt++;
                    }
                    if (cnt == 3) {
                        list.add(new int[]{i, j});
                    }
                }
            }
        }
    }

    static void remove(String[][] arr) {
        for (int[] i : list) {
            int[] temp = i;
            if(!arr[temp[0]][temp[1]].equals("")) {
                arr[temp[0]][temp[1]] = "";
                answer++;
            }
            for (int j = 0; j < 3; j++) {
                int nx = temp[0] + dx[j];
                int ny = temp[1] + dy[j];
                if(!arr[nx][ny].equals("")) {
                    arr[nx][ny] = "";
                    answer++;
                }
            }
        }
        list.clear();
        System.out.println(Arrays.deepToString(arr));
    }

    static void pull(String[][] arr) {
        for (int i = arr.length; i < 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j].equals("")) {
                    arr[i][j] = arr[i - 1][j];
                    arr[i - 1][j] = "";
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
