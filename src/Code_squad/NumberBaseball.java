package Code_squad;
// 문제 링크 : https://github.com/code-squad/test-item-pool/blob/master/level2-common/level2.md

import java.util.*;

public class NumberBaseball {
    // 메인 메서드
    // 2라인 depth 0
    public static void main(String[] args) {
        // 숫자 메서드 호출
        String n = makeNum();
        // 테스트를 위해 n 출력
        System.out.println(n);

        // 입력 메서드 호출
        input(n);
    }

    // 컴퓨터가 만들 숫자를 정하는 메서드
    // 10라인, depth 1
    static String makeNum() {
        Set<String> set = new HashSet<>();
        // 1부터 9까지 랜덤 생성후 set에 섭압
        while (set.size() < 3) {
            // 정수범위 지정 : (int) Math.random() * (최댓값-최소값+1) + 최소값
            String temp = String.valueOf((int) (Math.random() * 7 + 1));
            set.add(temp);
        }

        // set을 String으로 변환
        String n = "";
        for (String s : set) {
            n += s;
        }
        return n;
    }

    // 시용자 입력 메서드
    // 9라인 depth 1
    static void input(String n) {
        // 사용자 입력
        Scanner sc = new Scanner(System.in);

        // 사용자가 정답을 맞출때까지 무한반복
        String answer = "";
        while (!n.equals(answer)) {
            System.out.print("숫자를 입력해주세요 ex)123 : ");
            String input = sc.next();

            count(input, n);
            answer = input;
        }
        sc.close();
    }

    // 스트라이크와 볼 개수를 세는 메서드
    // 8라인 depth 2
    static void count(String input, String n) {
        String[] convertTemp = input.split("");
        int strike = 0, ball = 0;

        // strike 개수와 ball 개수 카운트
        for (int i = 0; i < input.length(); i++) {
            // 각 자리수 비교 메서드 호출
            int result = check(convertTemp[i], i, n);
            if(result == 1) strike++;
            if(result == 2) ball++;
        }

        // 출력 메서드 호출
        output(strike, ball);
    }

    // n과 input의 각 자리수를 비교하는 메서드
    // 10라인 depth 2
    static int check(String input, int idx, String n) {
        int result = 0;
        String[] checkTemp = n.split("");
        // input의 idx가 n에 포함되는지
        if (n.contains(input)) {
            // idx가 맞는지
            if (checkTemp[idx].equals(input)) {
                result = 1;
                return result;
            }
            result = 2;
        }
        return result;
    }

    // 결과와 힌트를 출력하는 메서드
    // 9라인 depth 1
    static void output(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        // 상세 비교가 필요하다면 subOutput 메서드 호출
        subOutput(strike, ball);
    }

    // 조건 상세 비교후 힌트 출력
    // 9라인 depth 1
    static void subOutput(int strike, int ball) {
        if(strike > 0 && ball > 0) {
            System.out.println(strike + " 스트라이크 " + ball + "볼");
        }

        if(strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }

        if(strike != 0 && ball == 0) {
            System.out.println(strike + " 스트라이크");
        }
    }
}
