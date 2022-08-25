package progammers;

import java.util.Arrays;

// 각 배열에 쏜다 안쏜다로 재귀 탐색해야 하지 않나
public class archeryCompetition_L2 {
    static int max;
    static int[] answer;

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        com(0, n, 0, info, new int[n]);
        answer = (max == 0) ? answer = new int[]{-1} : answer;

        System.out.println(Arrays.toString(answer));
    }

    // 증복 조합 메서드
    static void com(int s, int n, int idx, int[] info, int[] result) {
        // n발을 전부 다 쐈다면
        if (idx == n) {
            // 점수 계산 메서드 호출
            cul(info, result);
            return;
        }

        // 라이언이 쏜 과녁을 중복 조합으로 만들기
        for (int i = s; i < 11; i++) {
            result[idx] = i;
            com(i, n, idx + 1, info, result);
        }
    }

    static void cul(int[] info, int[] result) {
        int[] info2 = new int[11];
        for (int i : result) {
            info2[10 - i]++;
        }

        int r = 0;
        int a = 0;

        for (int i = 0; i < info.length; i++) {
            int score = 10 - i;

            if (info2[i] > info[i]) {
                r += score;
            } else if (info2[i] < info[i]) {
                a += score;
            } else if (info[i] != 0 && info2[i] == info[i]) {
                a += score;
            }
        }
        if (r - a > max) {
            max = r - a;
            answer = info2;
        }
        return;
    }
}
