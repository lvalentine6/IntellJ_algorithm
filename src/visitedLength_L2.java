import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class visitedLength_L2 {
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, -1, 0, 0};
    static int answer;

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        answer = 0;

        int[][] arr = new int[11][11];
        boolean[][] visited = new boolean[7][7];

        bfs(arr, dirs, 5, 5, visited);

        System.out.println(Arrays.deepToString(arr));
        System.out.println(answer);
    }

    static void bfs(int[][] arr, String dirs, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        String[] temp = dirs.split("");

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("U")) {
                if ((x < 12 && y < 12) && !(arr[x][y] == 1 && arr[x][y + 1] == 1)) {
                    arr[x][y] = 1;
                    arr[x][y + 1] = 1;
                    y = y + 1;
                    answer++;
                }
            } else if (temp[i].equals("D")) {
                if ((x < 12 && y < 12) && !(arr[x][y] == 1 && arr[x][y - 1] == 1)) {
                    arr[x][y] = 1;
                    arr[x][y - 1] = 1;
                    y = y - 1;
                    answer++;
                }
            } else if (temp[i].equals("R")) {
                if ((x < 12 && y < 12) && !(arr[x][y] == 1 && arr[x + 1][y] == 1)) {
                    arr[x][y] = 1;
                    arr[x + 1][y] = 1;
                    x = x + 1;
                    answer++;
                }
            } else {
                if ((x < 12 && y < 12) && !(arr[x][y] == 1 && arr[x - 1][y] == 1)) {
                    arr[x][y] = 1;
                    arr[x - 1][y] = 1;
                    x = x - 1;
                    answer++;
                }
            }
            System.out.println("x : " + (x - 5));
            System.out.println("y : " + (y - 5));

        }
    }
}
