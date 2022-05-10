package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 k를 분리하기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // k를 담는 배열
        Integer[] coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        // 내림차순으로 정렬
        Arrays.sort(coin, Collections.reverseOrder());
        // 가장 큰 동전의 단위로 낼수 있는 만큼 내고 다음 동전 단위로 넘어가기
        int i = 0;
        while (k != 0) {
            if(k - coin[i] >= 0) {
                k = k - coin[i];
                answer++;
            } else {
                i++;
            }
        }
        System.out.println(answer);
    }
}
