package progammers;

public class CountryNumber124 {
    public static void main(String[] args) {
        int n = 9;
        String answer = "";

        while(n > 0) {
            if(n % 3 < 10) {
                answer += n % 3;
            }
            else {

            }
            n /= 3;
        }

        System.out.println(answer);
    }
}
