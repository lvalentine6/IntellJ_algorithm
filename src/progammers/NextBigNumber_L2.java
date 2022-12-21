package progammers;

public class NextBigNumber_L2 {
    public static void main(String[] args) {
        int n = 78;
        int answer = 0;

        int ncnt = 0;
        int bcnt = 0;

        // n을 2진수로 변환하고 1개수 세기
        String ns = Integer.toBinaryString(n);

        for (int i = 0; i < ns.length(); i++) {
            if (ns.charAt(i) == '1') {
                ncnt++;
            }
        }

        // n을 1씩 늘리며 1개수 숫자 세기
        int temp = n + 1;
        while (ncnt != bcnt) {
            String temps = Integer.toBinaryString(temp);
            for (int i = 0; i < temps.length(); i++) {
                if (temps.charAt(i) == '1') {
                    bcnt++;
                }
            }
            if (ncnt != bcnt) {
                bcnt = 0;
                temp++;
            }
        }

        System.out.println(temp);

    }
}
