package progammers;

import java.util.Arrays;

public class quadCompact_L2 {
    static int[] answer;

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
//        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        answer = new int[2];

        int idx = arr.length / 2;

        recursion(arr, idx);
        System.out.println(Arrays.toString(answer));
    }

    static void recursion(int[][] arr, int idx) {
        if(idx == 0) {
            return;
        }

        boolean flag = false;
        int temp = arr[0][0];
        roof : for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                if (!(i == 0 && j == 0)) {
                    if (arr[i][j] != temp) {
                        flag = true;
                        break roof;
                    }
                }
            }
        }
        if (!flag) {
            answer[temp]++;
        } else {
            recursion(arr, idx / 2);
        }

        flag = false;
        temp = arr[idx][0];
        roof : for (int i = idx; i < arr.length; i++) {
            for (int j = 0; j < idx; j++) {
                if (!(i == 0 && j == 0)) {
                    if (arr[i][j] != temp) {
                        flag = true;
                        break roof;
                    }
                }
            }
        }

        if (!flag) {
            answer[temp]++;
        } else {
            recursion(arr, idx / 2);
        }

        flag = false;
        temp = arr[0][idx];

        roof : for (int i = 0; i < 1; i++) {
            for (int j = idx; j < arr.length; j++) {
                if (!(i == 0 && j == 0)) {
                    if (arr[i][j] != temp) {
                        flag = true;
                        break roof;
                    }
                }
            }
        }

        if (!flag) {
            answer[temp]++;
        } else {
            recursion(arr, idx / 2);
        }

        flag = false;
        temp = arr[idx][idx];
        roof : for (int i = idx; i < arr.length; i++) {
            for (int j = idx; j < arr.length; j++) {
                if (!(i == 0 && j == 0)) {
                    if (arr[i][j] != temp) {
                        flag = true;
                        break roof;
                    }
                }
            }
        }

        if (!flag) {
            answer[temp]++;
        } else {
            recursion(arr, idx / 2);
        }
    }
}
