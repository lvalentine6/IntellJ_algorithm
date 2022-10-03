package progammers;

import java.util.Arrays;

public class bestSet_L3 {
    public static void main(String[] args) {
        int n = 2;
        int s = 1;
        int[] answer = new int[n];

        int cnt = n;
        for (int i = 0; i < n; i++) {
            int temp = s / cnt;
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
