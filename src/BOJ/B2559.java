package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        // 입력값 배열 삽입
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // 처음으로 구해진 합을 최댓값을 설정
            if(i == k - 1) {
                max = sum;
            }

            // 한칸씩 밀며 합 구하기
            if(i >= k) {
                sum -= arr[i - k];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);

    }
}
