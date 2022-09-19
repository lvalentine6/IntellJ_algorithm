package progammers;

import java.util.*;

public class visitedLength_L2 {
    static int answer;

    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        answer = 0;

        // 3차원 배열을 통해 경로 체크
        int[][][] visited = new int[11][11][4];

        search(dirs, 10, 10, visited);

        System.out.println(answer);
    }

    static void search(String dirs, int x, int y, int[][][] visited) {
        String[] temp = dirs.split("");
        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "U":
                    if (x + 1 >= 11) {
                        continue;
                    }
                    if (visited[x][y][0] == 0) {
                        visited[x][y][0] = 1;
                        visited[x + 1][y][1] = 1;
                        answer++;
                    }
                    x += 1;
                    break;
                case "D":
                    if (x - 1 < 0) {
                        continue;
                    }
                    if (visited[x][y][1] == 0) {
                        visited[x][y][1] = 1;
                        visited[x - 1][y][0] = 1;
                        answer++;
                    }
                    x -= 1;
                    break;
                case "R":
                    if (y + 1 >= 11) {
                        continue;
                    }
                    if (visited[x][y][2] == 0) {
                        visited[x][y][2] = 1;
                        visited[x][y + 1][3] = 1;
                        answer++;
                    }
                    y += 1;
                    break;
                case "L":
                    if (y - 1 < 0) {
                        continue;
                    }
                    if (visited[x][y][3] == 0) {
                        visited[x][y][3] = 1;
                        visited[x][y - 1][2] = 1;
                        answer++;
                    }
                    y -= 1;
                    break;
            }
        }
    }
}
