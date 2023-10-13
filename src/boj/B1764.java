package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> dset = new TreeSet<>();
        Set<String> bset = new TreeSet<>();
        String[] d = new String[n];
        String[] b = new String[m];

        for (int i = 0; i < n; i++) {
            dset.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            bset.add(br.readLine());
        }

        dset.retainAll(bset);

        sb.append(dset.size()).append("\n");
        for (String s : dset) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
