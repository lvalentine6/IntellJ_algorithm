package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        String s = br.readLine();
        String[] temp = s.split(" ");
        int answer = 0;

        // 입력을 p배열에 넣기
        for (int i = 0; i < p.length; i++) {
            p[i] = Integer.parseInt(temp[i]);
        }
        // p 배열 정렬
        Arrays.sort(p);

        // 합을 구하기 위한 배열
        int[] total = new int[n];
        // total 첫번째 값 넣기
        total[0] = p[0];
        for (int i = 1; i < p.length; i++) {
            total[i] = total[i - 1] + p[i];
        }
        // 배열 전체 합
        answer = Arrays.stream(total).sum();

        System.out.println(answer);
    }
}
