package progammers;

import java.util.HashSet;
import java.util.Iterator;

public class PrimeNumber_L2 {

    // 전역변수로 HashSet 선언
    HashSet<Integer> hs = new HashSet<>();

    public int solution(String numbers) {
        // 재귀를 이용해서 모든 조합 만들기
        rec("", numbers);

        // 소수 개수 세기
        int cnt = 0;
        // Iterator를 이용하여 해시셋 탐색
        Iterator<Integer> ite = hs.iterator();
        while (ite.hasNext()) {
            int number = ite.next();
            // 소수이면 cnt 증가
            if (primeNumber(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    // 재귀를 이용한 조합 메소드
    public void rec(String temp, String n) {
        // 현재 조합을 set에 추가
        if (!temp.equals("")) {
            hs.add(Integer.parseInt(temp));
        }

        // 나머지 숫자를 더해 조합 만들기
        for (int i = 0; i < n.length(); i++) {
            // 재귀 호출
            rec(temp + n.charAt(i), n.substring(0, i) + n.substring(i + 1));
        }
    }

    // 소수 판별 메소드
    static boolean primeNumber(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 테스트
    public static void main(String[] args) {
        PrimeNumber_L2 pn = new PrimeNumber_L2();
        System.out.println(pn.solution("17"));
    }
}
