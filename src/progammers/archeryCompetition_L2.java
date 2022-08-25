package progammers;

import java.util.Arrays;

public class archeryCompetition_L2 {
    static int max;
    static int[] answer;

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        // 중복 조합 메서드 호출
        com(0, n, 0, info, new int[n]);

        // max가 0이면 라이언이 이긴 조합이 없다는 것
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

    // 점수를 계산하는 메서드
    static void cul(int[] info, int[] result) {
        int[] info2 = new int[11];
        // 조합을 info와 같은 배열로 만들기
        for (int i : result) {
            info2[10 - i]++;
        }

        // 라이언과 어피치 점수를 저장하는 변수
        int r = 0;
        int a = 0;

        for (int i = 0; i < info.length; i++) {
            int score = 10 - i;
            // 라이언의 점수가 더 크다면
            if (info2[i] > info[i]) {
                r += score;
                // 어피치의 점수가 더 크다면
            } else if (info2[i] < info[i]) {
                a += score;
                // 어피치가 과녁에 맞췄고 라이언과 어피치의 점수가 같다면
            } else if (info[i] != 0 && info2[i] == info[i]) {
                a += score;
            }
        }

        // 라이언의 점수가 높고 max보다 크다면
        if (r - a > max) {
            max = r - a;
            answer = info2;
        }
        return;
    }
}
