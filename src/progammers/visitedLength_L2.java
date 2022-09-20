package progammers;

public class visitedLength_L2 {
    static int answer;

    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        answer = 0;

        // 3차원 배열을 통해 경로 체크
        int[][][] visited = new int[11][11][4];

        // 경로 탐색 메서드 호출
        search(dirs, 5, 5, visited);

        System.out.println(answer);
    }

    // 경로 탐색 메서드
    static void search(String dirs, int x, int y, int[][][] visited) {
        String[] temp = dirs.split("");
        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                // 경로가 위라면
                case "U":
                    // 범위를 벗어나면
                    if (x + 1 >= 11) {
                        continue;
                    }
                    // 위에서 아래로 오는것과 아래에서 위로 가는건 같은 경로
                    if (visited[x][y][0] == 0) {
                        visited[x][y][0] = 1;
                        visited[x + 1][y][1] = 1;
                        answer++;
                    }
                    // 움직이기
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
