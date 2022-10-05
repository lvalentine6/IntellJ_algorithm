package progammers;

import java.util.Arrays;

public class bestSet_L3 {
    public static void main(String[] args) {
        int n = 2;
        int s = 1;

        // 배열의 크기 n으로 초기화
        int[] answer = new int[n];

        int cnt = n;
        for (int i = 0; i < n; i++) {
            int temp = s / cnt;
            // 0이 하나라도 있으면 모든 원소의 곱은 0
            if(temp == 0) {
                answer = new int[]{-1};
                // return answer;
            }
            answer[i] = temp;
            s -= temp;
            cnt--;
        }
        System.out.println(Arrays.toString(answer));
    }
}
