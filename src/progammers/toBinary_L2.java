package progammers;

import java.util.Arrays;

public class toBinary_L2 {
    public static void main(String[] args) {
        String s = "110010101001";
        int[] answer = new int[2];
        int sum = 0;

        // s가 1이 아니면 실행
        while (!s.equals("1")) {
            // 임시 String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') {
                    sb.append("1");
                } else {
                    sum++;
                }
            }
            // s에 temp의 길이를 이진변환 후 대입
            s = Integer.toString(sb.length(), 2);
            // 실행횟수 증가
            answer[0]++;
        }
        // 제거한 0개수 삽입
        answer[1] = sum;
        System.out.println(Arrays.toString(answer));
    }
}
