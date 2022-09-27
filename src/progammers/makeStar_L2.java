package progammers;

import java.util.*;

public class makeStar_L2 {
    static List<int[]> list;
    static int[] xMinMax;
    static int[] yMinMax;

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        list = new ArrayList<>();
        xMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        yMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                makePoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
            }
        }

        List<String> arr = new ArrayList<>();
        for (int i = yMinMax[0]; i <= yMinMax[1]; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = xMinMax[0]; j <= xMinMax[1]; j++) {
                boolean flag = false;
                for (int k = 0; k < list.size(); k++) {
                    int x = list.get(k)[0];
                    int y = list.get(k)[1];
                    if(i == y && j == x) {
                        sb.append("*");
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    sb.append(".");
                }
            }
            arr.add(sb.toString());
        }
        Collections.reverse(arr);

        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    static void makePoint(long a, long b, long e, long c, long d, long f) {
        long x = (b * f - e * d) / (a * d - b * c);
        long y = (e * c - a * f) / (a * d - b * c);

        if((b * f - e * d) % (a * d - b * c) == 0 && (e * c - a * f) % (a * d - b * c) == 0) {
            list.add(new int[] {(int)x, (int) y});

            xMinMax[0] = Math.min(xMinMax[0], (int)x);
            xMinMax[1] = Math.max(xMinMax[1], (int)x);
            yMinMax[0] = Math.min(yMinMax[0], (int)y);
            yMinMax[1] = Math.max(yMinMax[1], (int)y);
        }
    }
}
