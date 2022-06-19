package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int temp = Integer.parseInt(st.nextToken());
                if (s.equals("I")) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                } else if (map.isEmpty()) {
                    continue;
                } else {
                    int key;
                    if (temp == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }
                    int cnt = map.get(key);
                    if (cnt == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, cnt - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
