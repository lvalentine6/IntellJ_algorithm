package progammers;

public class jumpAndTeleport {
    public static void main(String[] args) {
        int n = 5000;
        int ans = 0;

        // dp (top-down)
        while (n > 0) {
            // 2로 나누어 떨어진다는것은 순간이동이 가능
            if (n % 2 == 0) {
                n /= 2;
                // 아니면 점프 한칸
            } else {
                n--;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
