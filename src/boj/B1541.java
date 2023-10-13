package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전체 계산값을 저장하기 위한 변수
        int sum = 0;
        // 첫번째 값만 저장하기 위한 카운트
        int cnt = 0;
        // -기준으로 문자열 분리
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            int temp = 0;
            // + 기준으로 문자열 분리
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            // + 기준으로 나눠진 토큰을 모두 더하기
            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }
            cnt++;
            if (cnt == 1) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
