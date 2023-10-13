package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        HashMap<Integer, Integer> hm = new HashMap();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(sortArr[i])) {
                hm.put(sortArr[i], rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(hm.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
