import java.util.*;

public class visitedLength_L2 {
    static int answer;
    static List<int[][]> list;
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        answer = 0;
        list = new ArrayList<>();

        int[][] arr = new int[11][11];
        Map<int[], boolean[]> map = new HashMap<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                int[] temp = new int[] {i, j};
                boolean[] temp2 = new boolean[4];
                map.put(temp, temp2);
//                System.out.println(Arrays.toString(temp));
//                System.out.println(Arrays.toString(map.get(temp)));
            }
        }
        int[] xy = new int[]{5, 5};
        System.out.println(map.containsKey(xy));
//        bfs(arr, dirs, xy, map);
        System.out.println(map.get(xy));
        System.out.println(answer);
    }

    static void bfs(int[][] arr, String dirs, int[] xy, Map<int[], boolean[]> map) {
        String[] temp = dirs.split("");
        int nx = xy[0];
        int ny = xy[1];
        for (int i = 0; i < temp.length; i++) {
            if (nx < 12 && ny < 12) {
                switch (temp[i]) {
                    case "U":
                        if(map.get(xy)[0]) {
                            map.get(xy)[0] = true;
                            answer++;
                        }
                        xy[1] += 1;
                        break;
                    case "D":
                        if(map.get(xy)[1]) {
                            map.get(xy)[1] = true;
                            answer++;
                        }
                        xy[1] -= 1;
                        break;
                    case "R":
                        if(map.get(xy)[2]) {
                            map.get(xy)[2] = true;
                            answer++;
                        }
                        xy[0] += 1;
                        break;
                    case "L":
                        if(map.get(xy)[3]) {
                            map.get(xy)[3] = true;
                            answer++;
                        }
                        xy[0] -= 1;
                        break;
                }
            }
        }
    }
}
