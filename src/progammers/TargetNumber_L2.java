package progammers;

public class TargetNumber_L2 {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);

            return answer;
        }

        // DFS
        public void dfs(int[] numbers, int depth, int target, int sum){
            // 마지막 노드 까지 탐색한 경우
            if(depth == numbers.length){
                if(target == sum) {
                    answer++;
                }
            } else {
                // 해당 노드의 값을 더하고 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum + numbers[depth]);
                // 해당 노드의 값을 빼고 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]);
            }
    }

    // 테스트
    public static void main(String[] args) {
        TargetNumber_L2 tn = new TargetNumber_L2();
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(tn.solution(numbers, target));
    }
}
