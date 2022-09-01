package progammers;

import java.util.*;

public class friends4Block_L2 {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static List<int[]> list;
    static int answer;
    static boolean flag;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        answer = 0;

        // 2차원 배열로 변경
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].split("");
        }

        // 제거할 블록의 시작 좌표를 저장할 list
        list = new ArrayList<>();
        // while문을 종료하기 위한 boolean
        flag = false;

        // 더이상 제거할 블록이 없다면 탐색 중지
        while (!flag) {
            search(arr);
            remove(arr);
            pull(arr);
        }
        System.out.println(answer);
    }

    // 제거할 블록의 좌표를 찾는 메서드
    static void search(String[][] arr) {
        // 2차원 배열의 모든 좌표를 탐색
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                // target 설정
                String target = arr[i][j];
                // 탐색할 블록이 "" 이면 탐색할 필요 없음
                if (target.equals("")) {
                    continue;
                }

                // 블록 4개가 모두 같은지 확인할 변수
                int cnt = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // target 블록과 같다면 cnt 증가
                    if (target.equals(arr[nx][ny])) {
                        cnt++;
                    }
                    // 제거해야할 4개의 블록이 모이면 target 좌표 저장
                    if (cnt == 3) {
                        list.add(new int[]{i, j});
                    }
                }
            }
        }
    }

    // 블록 제거 메서드
    static void remove(String[][] arr) {
        for (int[] i : list) {
            int[] temp = i;
            // target의 블록 먼저 제거
            // 블록이 ""이 아니라면 빈칸으로 만들고 answer 증가
            if (!arr[temp[0]][temp[1]].equals("")) {
                arr[temp[0]][temp[1]] = "";
                answer++;
            }
            // 왼쪽, 아래, 대각선 블록 제거
            for (int j = 0; j < 3; j++) {
                int nx = temp[0] + dx[j];
                int ny = temp[1] + dy[j];
                if (!arr[nx][ny].equals("")) {
                    arr[nx][ny] = "";
                    answer++;
                }
            }
        }
        // 만약 제거해야할 블록이 없다면 flag 상태 변경
        if(list.isEmpty()) {
            flag = true;
        }

        // 다음 탐색을 위해서 list clear
        list.clear();
    }

    // 블록을 아래로 떨어트리는 메서드
    static void pull(String[][] arr) {
        // 가장 밑 행부터 탐색
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                // 탐색하다 ""을 만나면 같은열의 이전 행의 값을 가져오기
                if (arr[i][j].equals("")) {
                    for (int k = i; k >= 0; k--) {
                        if (!arr[k][j].equals("")) {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = "";
                            break;
                        }
                    }
                }
            }
        }
    }
}
