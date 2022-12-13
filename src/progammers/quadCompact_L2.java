package progammers;

import java.util.Arrays;

public class quadCompact_L2 {
    static int[] answer;

    public static void main(String[] args) {
//        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}};
        answer = new int[2];

        // 영역 분할 메서드 호출
        recursion(arr, 0, 0, arr.length);

        System.out.println(Arrays.toString(answer));
    }

    // 영역 분할 메서드
    static void recursion(int[][] arr, int x, int y, int size) {
        // 현재 영역이 압축 가능하다면 answer 배열에 값 추가하고 반환
        if (compact(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }
        // 1번 영역
        recursion(arr, x, y, size / 2);
        // 2번 영역
        recursion(arr, x + size / 2, y, size / 2);
        // 3번 영역
        recursion(arr, x, y + size / 2, size / 2);
        // 4번 영역
        recursion(arr, x + size / 2, y + size / 2, size / 2);
    }

    // 압축 가능한지 판단하는 메서드
    static boolean compact(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 영역의 첫번째 값과 나머지를 비교하다 하나다로 다르면 반환
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
