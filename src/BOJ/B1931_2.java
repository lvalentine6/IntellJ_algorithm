package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int cnt = 0;
        int preEnd = 0;
        // 압력값 배열에 삽입
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 정렬 (람다 사용)
        Arrays.sort(arr, (o1, o2) -> {
            // 종료시간이 같은 경우 시작시간을 기준으로 오름차순 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            // 종료 시간을 기준으로 오름차순 정렬
            return o1[1] - o2[1];
        });
        // 정렬후 카운팅
        for (int i = 0; i < n; i++) {
            if (preEnd <= arr[i][0]) {
                preEnd = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
