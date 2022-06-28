package progammers;

public class Picture_L2 {
    static int answer;
    static String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        boolean[] visited = new boolean[8];
        answer = 0;
        dfs("", visited, data);
        System.out.println(answer);
    }

    static void dfs(String orders, boolean[] visited, String[] data) {
        // 재귀 탈출문
        if (orders.length() == 8) {
            if (check(orders, data)) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String order = orders + arr[i];
                dfs(order, visited, data);
                visited[i] = false;
            }
        }
    }

    static boolean check(String orders, String[] data) {
        for (String s : data) {
            // 첫번째 프렌즈
            int first = orders.indexOf(s.charAt(0));
            // 두번째 프렌즈
            int second = orders.indexOf(s.charAt(2));
            // 조건
            char op = s.charAt(3);
            // 거리
            int length = s.charAt(4);
            if (op == '=') {
                if (!(Math.abs(first - second) - 1 == length)) return false;
            } else if (op == '>') {
                if (!(Math.abs(first - second) - 1 > length)) return false;
            } else {
                if (!(Math.abs(first - second) - 1 < length)) return false;
            }
        }
        return true;
    }
}
