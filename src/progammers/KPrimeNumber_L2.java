package progammers;

public class KPrimeNumber_L2 {
    static int answer;

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        answer = 0;

        // 진수 변환후 0을 기준으로 배열 만들기
        String[] arr = Integer.toString(n, k).split("0");

        for (int i = 0; i < arr.length; i++) {
            // 빈 문자열일 경우 통과
            if (arr[i].equals("")) {
                continue;
            }
            isPrimeNumber(arr[i]);
        }

        System.out.println(answer);

    }

    // 소수 판별 메서드
    static void isPrimeNumber(String prime) {
        // 변환시 문자열의 길이가 길어서 오버플로우 방지를 위해 long으로
        long n = Long.parseLong(prime);

        // 1은 소수가 아님
        if (n <= 1) {
            return;
        }

        boolean check = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 나누어 떨어지면 소수가 아님
            if (n % i == 0) {
                check = true;
                break;
            }
        }
        if (!check) {
            answer++;
        }
    }
}
