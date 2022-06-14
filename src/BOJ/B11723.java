package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B11723 {
    static int n;
    static HashSet<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if (st.hasMoreTokens()) {
                cal(temp, Integer.parseInt(st.nextToken()));
            } else {
                cal2(temp);
            }
        }
        System.out.println(sb);
    }

    static void cal(String string, int num) {
        if (string.equals("add")) {
            set.add(num);
        } else if (string.equals("remove")) {
            set.remove(num);
        } else if (string.equals("check")) {
            if (set.contains(num)) {
                sb.append(1).append("\n");
            } else sb.append(0).append("\n");
        } else if (string.equals("toggle")) {
            if (set.contains(num)) {
                set.remove(num);
            } else set.add(num);
        }
    }

    static void cal2(String string) {
        if (string.equals("all")) {
            set.clear();
            for (int i = 1; i < 21; i++) {
                set.add(i);
            }
        } else {
            set.clear();
        }
    }
}
