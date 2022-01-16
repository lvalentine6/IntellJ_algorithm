package progammers;

import java.util.Arrays;

public class StockPrice_L2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        // 이중 for문을 돌면서 값 비교
       for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 현재 값보다 뒤 값이 커지면
                if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                }
                answer[i]++;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
