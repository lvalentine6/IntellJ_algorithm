package progammers;

import java.util.Arrays;

public class Cipherplus {
    public static void main(String[] args) {
        int n = 123;
        int answer = 0;

        String[] temp = String.valueOf(n).split("");

        for(int i=0; i< temp.length; i++) {
            answer += Integer.parseInt(temp[i]);
        }

        System.out.println(answer);
    }
}
