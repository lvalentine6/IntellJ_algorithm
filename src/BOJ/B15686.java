package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1. 각 치킨집의 개수를 구하고 m개를 선택해 조합구하기
// 2. 만약 치킨집의 개수와 m이 같다면 바로 3번으로
// 3. 구한 조합으로 각 집마다 모든 치킨집에 대한 치킨거리 구하여 최솟값을 선택
// 4. 최솟값을 모두 더하면 도시의 치킨거리가 최소

public class B15686 {
    static int n, m;
    static ArrayList<Set<Integer>> comList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        HashMap<Integer, int[]> chickenMap = new HashMap<>();
        int chickenCnt = 0;

        // 입력값 배열 삽입 및 치킨집 map에 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    chickenCnt++;
                    chickenMap.put(chickenCnt, new int[]{i, j});
                }
            }
        }

        // 치킨집 조합 구하기
        boolean[] visited = new boolean[chickenMap.keySet().size()];
        comList = new ArrayList<>();
        com(chickenMap.keySet(), visited, 0, m);

        System.out.println(Arrays.deepToString(arr));
        System.out.println(chickenMap.keySet());

        for(Set<Integer> temp : comList) {
            System.out.println(temp);
        }

    }

    static void com(Set<Integer> key, boolean[] visit, int idx, int r) {
        if (r == 0) {
            return;
        }
        for (int i = 0; i < key.size(); i++) {
            visit[i] = true;
            com(key, visit, idx + 1, r - 1);
            visit[i] = false;
        }
    }
}
