package Codility.Test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3, 5, 4};
        boolean[] visited = new boolean[A.length + 1];
        Set<Integer> set = new HashSet<>();
        int cnt = 0;

        for (int i : A) {
            visited[i] = true;
            System.out.println(Arrays.toString(visited));
            int temp = 0;
            for (int j = 1; j < visited.length; j++) {
                if(visited[j] == true) {
                    temp++;
                } else {
                    break;
                }
            }
            set.add(temp);
        }

        for(int j : set) {
            if(j != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
