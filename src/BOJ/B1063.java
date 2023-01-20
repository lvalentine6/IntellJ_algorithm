package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1063 {
    static int[][] board;
    static int[] kingXy;
    static int[] stoneXy;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String kingPosition = stringTokenizer.nextToken();
        String stonePosition = stringTokenizer.nextToken();
        int cnt = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[8][8];
        kingXy = new int[2];
        stoneXy = new int[2];

        convertPosition(kingPosition, stonePosition);

        for (int i = 0; i < cnt; i++) {
            move(bufferedReader.readLine());
        }

        Map<Integer, Integer> rankMap = new HashMap<>();
        Map<Character, Integer> fileMap = new HashMap<>();

        int rankCnt = 8;
        char fileCnt = 'A';
        for (int i = 0; i < 8; i++) {
            rankMap.put(rankCnt--, i);
            fileMap.put(fileCnt++, i);
        }

        System.out.println(Arrays.toString(kingXy));
        System.out.println(Arrays.toString(stoneXy));
//        System.out.println(Arrays.deepToString(board));
    }

    static public void convertPosition(String kingPosition, String stonePosition) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        Map<Character, Integer> fileMap = new HashMap<>();

        int rankCnt = 8;
        char fileCnt = 'A';
        for (int i = 0; i < 8; i++) {
            rankMap.put(rankCnt--, i);
            fileMap.put(fileCnt++, i);
        }

        board[rankMap.get(Integer.parseInt(String.valueOf(kingPosition.charAt(1))))][fileMap.get(kingPosition.charAt(0))] = 1;
        board[rankMap.get(Integer.parseInt(String.valueOf(stonePosition.charAt(1))))][fileMap.get(stonePosition.charAt(0))] = 2;
        kingXy[0] = rankMap.get(Integer.parseInt(String.valueOf(kingPosition.charAt(1))));
        kingXy[1] = fileMap.get(kingPosition.charAt(0));
        stoneXy[0] = rankMap.get(Integer.parseInt(String.valueOf(stonePosition.charAt(1))));
        stoneXy[1] = fileMap.get(kingPosition.charAt(0));
    }

    static void move(String input) {
        Map<String, int[]> moveMap = new HashMap<>();
        moveMap.put("R", new int[]{0, 1});
        moveMap.put("L", new int[]{0, -1});
        moveMap.put("B", new int[]{1, 0});
        moveMap.put("T", new int[]{-1, 0});
        moveMap.put("RT", new int[]{-1, 1});
        moveMap.put("LT", new int[]{-1, -1});
        moveMap.put("RB", new int[]{1, 1});
        moveMap.put("LB", new int[]{1, -1});

        int[] temp = moveMap.get(input);

        if((kingXy[0] + temp[0] > 0 && kingXy[0] + temp[0] < 7) && (kingXy[1] + temp[1] > 0 && kingXy[1] + temp[1] < 7)) {
            if(kingXy[0] + temp[0] == stoneXy[0] && kingXy[1] + temp[1] == stoneXy[1]) {
                if((stoneXy[0] + temp[0] > 0 && stoneXy[0] + temp[0] < 7) && (stoneXy[1] + temp[1] > 0 && stoneXy[1] + temp[1] < 7)) {
                    return;
                }
                stoneXy[0] = stoneXy[0] + temp[0];
                stoneXy[1] = stoneXy[1] + temp[1];
            }
            kingXy[0] = kingXy[0] + temp[0];
            kingXy[1] = kingXy[1] + temp[1];
        }
    }
}
