package progammers;

import java.math.BigInteger;

public class Quadrangle_L2 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        // 입력값 long으로 변환
        long lw = Long.valueOf(w);
        long lh = Long.valueOf(h);

        // 최대공약수
        int gcd = BigInteger.valueOf(lw).gcd(BigInteger.valueOf(lh)).intValue();

        // 전체 사각형
        long quadrangle = lw * lh;

        // 반복되는 사각형에서 사용할 수 없는 사각형의 개수
        long reQuadrangle = ((lw / gcd) + (lh / gcd) - 1) * gcd;

        // 답
        long answer = quadrangle - reQuadrangle;

        System.out.println(answer);

    }
}
