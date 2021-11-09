package progammers;

import java.util.Arrays;

public class SecreatMap2 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] answer = new String[n];

        StringBuilder sb = new StringBuilder();

        // 비트연산
        for (int i=0; i<n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i=0; i<n; i++){
            // format을 이용해서 n만큼 자리수 설정
            answer[i] = String.format("%"+n+"s", answer[i]);
            answer[i] = answer[i].replace("1", "#");
            answer[i] = answer[i].replace("0", " ");
        }

        System.out.println(Arrays.toString(answer));
    }
}
