package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= cnt; i++) {
            String[][] arr = new String[3][3];
            boolean[][] visited = new boolean[3][3];
            String flag = "";
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    if (br.readLine().equals("o")) {
                        flag = "o";
                    } else {
                        flag = "x";
                    }
                    break;
                }
                String[] temp = br.readLine().split("");
                convertArray(arr, temp, j);
            }
            search(arr, visited, flag);
            sb.append("Case ").append(i).append(":").append("\n");
            for (int j = 0; j < 3; j++) {
                if (i == cnt && j == 2) {
                    sb.append(arr[j][0]).append(arr[j][1]).append(arr[j][2]);
                } else {
                    sb.append(arr[j][0]).append(arr[j][1]).append(arr[j][2]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static void convertArray(String[][] arr, String[] temp, int j) {
        for (int i = 0; i < 3; i++) {
            arr[j][i] = temp[i];
        }
    }

    static void search(String[][] arr, boolean[][] visited, String flag) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals("-") && !visited[i][j]) {
                    visited[i][j] = true;
                    arr[i][j] = flag;
                    if (check(arr, flag)) {
                        return;
                    }
                    arr[i][j] = "-";
                }
            }
        }
    }

    static boolean check(String[][] arr, String flag) {
        if (flag.equals(arr[0][0]) && flag.equals(arr[0][1]) && flag.equals(arr[0][2])) {
            return true;
        } else if (flag.equals(arr[0][0]) && flag.equals(arr[1][0]) && flag.equals(arr[2][0])) {
            return true;
        } else if (flag.equals(arr[0][0]) && flag.equals(arr[1][1]) && flag.equals(arr[2][2])) {
            return true;
        } else if (flag.equals(arr[0][1]) && flag.equals(arr[1][1]) && flag.equals(arr[2][1])) {
            return true;
        } else if (flag.equals(arr[0][2]) && flag.equals(arr[1][1]) && flag.equals(arr[2][0])) {
            return true;
        } else if (flag.equals(arr[1][0]) && flag.equals(arr[1][1]) && flag.equals(arr[1][2])) {
            return true;
        } else if (flag.equals(arr[2][0]) && flag.equals(arr[2][1]) && flag.equals(arr[2][2])) {
            return true;
        }
        return false;
    }
}
