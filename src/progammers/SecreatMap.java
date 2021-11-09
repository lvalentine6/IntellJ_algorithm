package progammers;

import java.util.Arrays;

public class SecreatMap {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] temp = new String[n];
        String[] answer = new String[n];
        StringBuilder sb1 = new StringBuilder();

        for (int i=0; i<n; i++) {
            // StringBuilder에 비트연산 값 설정
            StringBuilder sb2  = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));

            // 앞에 0을 삽입해 자릿수 맞춰놓기
            while(sb2.length() != n) {
                sb2.insert(0, 0);
            }

            // temp 배열에 비트연산 결과 넣기
            temp[i] = sb2.toString();
        }

        for (int i=0; i< temp.length; i++) {
            for (int j=0; j< temp[i].length(); j++) {
                // temp 배열을 요소들 돌며 검사
                char ch = temp[i].charAt(j);
                if(ch == '1') {
                    sb1.append("#");
                }
                else {
                    sb1.append(" ");
                }
            }
            // answer 배열에 문자열 추가
            answer[i] = sb1.toString();
            // StringBuilder 초기화
            sb1 = new StringBuilder();
        }
        System.out.println(Arrays.toString(answer));
    }
}
