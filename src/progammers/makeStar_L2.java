package progammers;

import java.util.*;

public class makeStar_L2 {
    static List<int[]> list;
    static int[] xMinMax;
    static int[] yMinMax;

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{1, -1, 0}, {-2, -1, 0}, {4, -1, 0}};

        list = new ArrayList<>();
        xMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        yMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        // line 배열을 순회하며 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                makePoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
            }
        }

        // 교점을 저장하기 위한 list
        List<String> arr = new ArrayList<>();

        // x,y의 좌표의 최솟값부터 최댓값까지 순회
        for (int i = yMinMax[1]; i >= yMinMax[0]; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = xMinMax[0]; j <= xMinMax[1]; j++) {
                // 별을 만들면서 교점의 좌표에는 *찍기
                boolean flag = false;
                // list에서 교점과 일치하는지 확인
                for (int k = 0; k < list.size(); k++) {
                    int x = list.get(k)[0];
                    int y = list.get(k)[1];
                    if(i == y && j == x) {
                        sb.append("*");
                        flag = true;
                        break;
                    }
                }
                // 교점이 아니면 . 찍기
                if(!flag) {
                    sb.append(".");
                }
            }
            arr.add(sb.toString());
        }

        // list 결과 반대로
//        Collections.reverse(arr);

        // answer 배열에 복사
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    // 교점을 구하는 메서드
    static void makePoint(long a, long b, long e, long c, long d, long f) {
        // 분모가 0이면
        if((a * d - b * c) == 0) {
            return;
        }

        long x = (b * f - e * d) / (a * d - b * c);
        long y = (e * c - a * f) / (a * d - b * c);

        // 좌표가 정수라면
        if((b * f - e * d) % (a * d - b * c) == 0 && (e * c - a * f) % (a * d - b * c) == 0) {
            list.add(new int[] {(int)x, (int) y});

            // x,y 좌표의 최댓, 최솟값 저장
            xMinMax[0] = Math.min(xMinMax[0], (int)x);
            xMinMax[1] = Math.max(xMinMax[1], (int)x);
            yMinMax[0] = Math.min(yMinMax[0], (int)y);
            yMinMax[1] = Math.max(yMinMax[1], (int)y);
        }
    }
}
