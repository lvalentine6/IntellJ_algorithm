package progammers;

public class PredictMatch_L2 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        int answer = search(n, a, b);
        System.out.println(answer);
    }

    // 대진 진행 메서드
    static int search(int n, int a, int b) {
        int first = 0;
        int second = 0;
        int cnt = 1;

        // while문 탈출을 위한 a, b 대소 빅교
        if (a > b) {
            first = a;
            second = b;
        } else {
            first = b;
            second = a;
        }

        // a와 b가 만나려면 작은수가 홀수이고 두 수의 차이가 1
        while (!(first % 2 != 0 && first - second == 1)) {
            first = (first + 1) / 2;
            second = (second + 1) / 2;
            cnt++;
        }

        return cnt;
    }
}
