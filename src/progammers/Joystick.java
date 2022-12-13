package progammers;

public class Joystick {
    public static void main(String[] args) {
        String name = "JEROEN";
        int answer = 0;

        int len = name.length();
        int min = len - 1;

        // 상하 M을 기준으로 더 가까운 경로 카운트
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) <= 'M') {
                answer += name.charAt(i) - 'A';
            } else {
                answer += 'Z' - name.charAt(i) + 1;
            }
            // 좌우 A가 연속될 겅우를 고려
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            min = Math.min(min, i + len - next + i);
        }

        answer += min;
        System.out.println(answer);

    }
}
