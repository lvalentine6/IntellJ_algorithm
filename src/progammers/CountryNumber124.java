package progammers;

public class CountryNumber124 {
    public static void main(String[] args) {
        int n = 10;
        String answer = "";

        // 효율성 통과를 위한 sb (그냥 더하면 통과 못함)
        StringBuilder sb = new StringBuilder();

        // 핵심은 3진법과 같지만 0에 대한 처리가 다름
        while(n > 0) {
            int remain = n % 3;
            n /= 3;
            if(remain == 0) {
                remain = 4;
                n--;
            }
            sb.append(remain);
        }

        // 반대로 StringBuilder 넣기
        answer = sb.reverse().toString();

        System.out.println(answer);
    }
}
