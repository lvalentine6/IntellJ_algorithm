package progammers;

public class network_L3 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;

        // 방문 배열 초기화
        boolean[] visited = new boolean[n];

        // n개의 컴퓨터에 대해 탐색
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 컴퓨터라면 탐색
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    static void dfs(int[][] computers, boolean[] visited, int idx) {
        // 현재 노드 방문처리
        visited[idx] = true;

        for (int i = 0; i < visited.length; i++) {
            // 자기 자신이 아니고 방문한적이 없고 값이 1이라면 재귀 호출
            if(idx != i && !visited[i] && computers[idx][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
