package progammers;

public class N_Queen_L2 {
    static int[] arr;
    static int cnt;

    public static void main(String[] args) {
        int n = 4;
        int answer = 0;

        // 2차원 배열을 1차원으로 압축 -> 인덱스를 행, 값을 열로 보는것
        arr = new int[n];

        // BackTracking 호출
        bt(n, 0);

        answer = cnt;
        System.out.println(answer);
    }

    // BackTracking 메서드
    static void bt(int n, int row) {
        // 모든 queen이 다 놓였다면
        if (n == row) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[row] = i;
            // 리턴값이 true이면(열을 늘려가며) BackTracking
            if (check(row)) {
                bt(n, row + 1);
            }
        }
    }

    // 가로, 세로, 대각선 확인 메서드
    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            // 0부터 row - 1까지 순환하면서 같은 행인지 검사
            if (arr[i] == arr[row]) {
                return false;
            }
            // 대각선 확인 (두 점의 기울기가 같으면 대각선에 위치한 것)
            if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
