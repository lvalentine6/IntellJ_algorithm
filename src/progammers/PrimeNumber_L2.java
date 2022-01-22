package progammers;

import java.util.Arrays;

public class PrimeNumber_L2 {
    public static void main(String[] args) {
        String numbers = "17";
        int answer = 0;

    }
    static boolean primeNumber(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
