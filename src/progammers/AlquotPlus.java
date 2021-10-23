package progammers;

public class AlquotPlus {
    public static void main(String[] args) {
        int n = 12;
        int answer = 0;
        for(int i =1; i<=n; i++) {
            if(n % i == 0) {
                answer += i;
            }
        }
    }
}
