package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
    static int[][] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentNode = st.nextToken().charAt(0) - 'A';
            int leftNode = st.nextToken().charAt(0) - 'A';
            int rightNode = st.nextToken().charAt(0) - 'A';

            tree[parentNode][0] = (leftNode == -19) ? -1 : leftNode;
            tree[parentNode][1] = (rightNode == -19) ? -1 : rightNode;
        }

        // 순회 메서드 호출
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    static void preOrder(int s) {
        if (s == -1) return;
        // 현재 노드 값 추가
        sb.append((char) (s + 'A'));
        // 왼쪽 자식 노드 호출
        preOrder(tree[s][0]);
        // 오른쪽 자식 노드 호출
        preOrder(tree[s][1]);
    }

    static void inOrder(int s) {
        if (s == -1) return;
        // 왼쪽 자식 노드 호출
        inOrder(tree[s][0]);
        // 현재 노드 추가
        sb.append((char) (s + 'A'));
        // 오른쪽 자식 노드 호출
        inOrder(tree[s][1]);
    }

    static void postOrder(int s) {
        if (s == -1) return;
        // 왼쪽 자식 노드 호출
        postOrder(tree[s][0]);
        // 오른쪽 자식 노드 호출
        postOrder(tree[s][1]);
        // 현재 노드 추가
        sb.append((char) (s + 'A'));
    }
}
