package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            hm1.put(i, s);
            hm2.put(s, i);
        }
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            // 숫자인지 판별
            if (temp.chars().allMatch(Character::isDigit)) {
                sb.append(hm1.get(Integer.parseInt(temp))).append("\n");
            } else {
                sb.append(hm2.get(temp)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
