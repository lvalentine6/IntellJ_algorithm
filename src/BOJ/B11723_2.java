package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class B11723_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        BitSet bs = new BitSet(21);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (st.hasMoreTokens()) {
                if (s.equals("add")) {
                    bs.set(Integer.parseInt(st.nextToken()));
                } else if (s.equals("remove")) {
                    bs.clear(Integer.parseInt(st.nextToken()));
                } else if (s.equals("check")) {
                    if (bs.get(Integer.parseInt(st.nextToken()))) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                } else if (s.equals("toggle")) {
                    bs.flip(Integer.parseInt(st.nextToken()));
                }
            } else if (s.equals("all")) {
                bs.set(1, 21, true);
            } else {
                bs.clear();
            }
        }

        System.out.println(sb);
    }
}
