package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B5430 {
    public static void main(String[] args) throws Exception {
        // 수행 시간 검사
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //입력값 배열 저장
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] s = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[|],");

            // 입력값 리스트 저장
            for (int j = 0; j < size; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            // 검사
            int cnt = 0;
            for (String value : s) {
                if (value.equals("R")) {
                    if (cnt == 0) {
                        list.sort(Collections.reverseOrder());
                        cnt++;
                    } else {
                        Collections.sort(list);
                        cnt = 0;
                    }
                } else {
                    if (list.size() == 0) {
                        sb.append("error").append("\n");
                    } else {
                        list.remove(0);
                    }
                }
            }
            // StringBuilder를 이용해서 출력문 만들기
            if (!(list.size() == 0)) {
                sb.append("[");
                for (int p : list) {
                    sb.append(p).append(",");
                }
                sb.deleteCharAt(sb.lastIndexOf(","));
                sb.append("]");
                sb.append("\n");
            }
        }
        System.out.println(sb);
        System.out.println((System.currentTimeMillis() - start) / 1000.0);
    }
}
