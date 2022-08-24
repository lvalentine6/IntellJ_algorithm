package Codility.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int[] A = new int[]{0, 3, 3, 7, 5, 3, 11, 1};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if(i == j) {
                    continue;
                }
                boolean flag = false;
                for (int k = 0; k < A.length; k++) {
                    if((A[k] > A[i] && A[k] < A[j]) || (A[k] > A[j] && A[k] < A[i])) {
                        flag = true;
                    }
                }
                if(!flag) {
                    list.add(Math.abs(A[i] - A[j]));
                }
            }
        }
        int answer = Collections.min(list);
        System.out.println(answer);

    }
}
