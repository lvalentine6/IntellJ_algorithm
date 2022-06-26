package progammers;

import java.util.ArrayList;
import java.util.Arrays;

public class line_L2 {
    static ArrayList<int[]> list;
    public static void main(String[] args) {
        int n = 3;
        long k = 5;
        int[] arr = new int[n];
        int[] out = new int[n];
        boolean[] visited = new boolean[n];
        list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        perm(arr, out, visited, 0, n);

        int[] answer = list.get((int) (k-1));

        System.out.println(Arrays.toString(answer));
    }
    static void perm(int[] arr, int[] out, boolean[] visited, int depth, int n) {
        if(depth == n) {
            list.add(out.clone());
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                perm(arr, out, visited, depth + 1, n);
                visited[i] = false;
            }
        }

    }
}
