package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1. 치킨집중에서 m개를 선택해 조합구하기
// 2. 구한 조합으로 각 집마다 치킨거리 구하여 최솟값을 선택
// 3. 각 집에 최솟값을 더하여 도시의 치킨거리 구하기
// 3. 모든 조합을 돌면서 도시의 치킨거리의 최솟값을 반환

public class B15686 {
    static int n, m, min;
    static int[] com;
    static ArrayList<int[]> chickenList;
    static ArrayList<int[]> homeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();

        // 조합을 저장할 배열
        com = new int[m];
        min = Integer.MAX_VALUE;

        // 입력값 배열 삽입 및 list에 치킨집과 집 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                } else if (arr[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                }
            }
        }
        combination(0, 0);
        System.out.println(min);
    }

    // 조합을 구하는 메서드
    static void combination(int idx, int depth) {
        // 조합이 하나 만들어지면 도시 치킨거리 구하기
        if (depth == m) {
            min = Math.min(minLength(), min);
            return;
        }
        for (int i = idx; i < chickenList.size(); i++) {
            com[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

    // 조합에서 치킨거리 구하기
    static int minLength() {
        // 현재 조합의 도시 치킨거리
        int sum = 0;
        for (int[] homeTemp : homeList) {
            int chickenLength = Integer.MAX_VALUE;
            int hx = homeTemp[0];
            int hy = homeTemp[1];

            for (int i = 0; i < com.length; i++) {
                int[] chickenTemp = chickenList.get(com[i]);
                int cx = chickenTemp[0];
                int cy = chickenTemp[1];

                // 각 집의 치킨거리
                chickenLength = Math.min(Math.abs(hx - cx) + Math.abs(hy - cy), chickenLength);
            }
            sum += chickenLength;
        }
        return sum;
    }
}
