package progammers;

import java.util.Arrays;

public class quadCompact_L2 {
    static int[] answer;

    public static void main(String[] args) {
//        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        answer = new int[2];

        int idx = arr.length / 2;

        System.out.println(Arrays.toString(answer));
    }

    static void recursion(int[][] arr, int x, int y, int size) {
        
    }
    
    static boolean compact(int x, int y, int size) {
        return false;
    }
}
