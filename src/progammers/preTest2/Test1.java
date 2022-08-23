package progammers.preTest2;

// 총 풀이시간 1시간 30분
// 코드 작성 20분, 디버깅 1시간 10분
// 재귀 실행시 sum의 값이 어떻게 변하는지 확인이 잘 안되었고 조합을 이상하게 만듬
public class Test1 {
    static int result;
    public static void main(String[] args) {
//        int[] number = {-2, 3, 0, 2, -5};
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int answer = 0;
        result = 0;
        boolean[] visited = new boolean[number.length];

        combination(number, 0, 0, 0, visited);

        answer = result;
        System.out.println(answer);
    }

    static void combination(int[] num, int idx, int sum, int cnt, boolean[] visited) {
        if (cnt == 3) {
            if (sum == 0) {
                result++;
            }
            return;
        }
        for (int i = idx; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += num[i];
                combination(num, i + 1, sum, cnt + 1, visited);
                sum -= num[i];
                visited[i] = false;
            }
        }
    }
}
