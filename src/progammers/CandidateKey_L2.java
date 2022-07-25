package progammers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 1. 모든 조합 만들기
// 2. 만들어진 조합으로 유일성, 최소성 검사

public class CandidateKey_L2 {
    static int answer;
    static int n,m;
    static List<HashSet<Integer>> candidateKey;
    static String[][] relationCopy;
    public static void main(String[] args) {
        relationCopy = new String[][] {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        answer = 0;

        // 중복 조합을 고려하여 HashSet 사용
        candidateKey = new ArrayList<>();
        n = relationCopy.length;
        m = relationCopy[0].length;

        // 1부터 m까지 사이즈만큼 조합 생성하기
        for (int i = 1; i < m + 1; i++) {
            combination(0, i, 0, new HashSet<>());
        }

        System.out.println(answer);

    }

    // 조합 생성 메서드
    static void combination(int idx, int size, int depth, HashSet<Integer> set) {
        // 조합이 만들어지면
        if(depth >= size) {
            // 유일성 검사
            if(!unique(set)) {
                return;
            }
            // 최소성 검사
            for (HashSet<Integer> key : candidateKey) {
                if(set.containsAll(key)) {
                    return;
                }
            }
            // 조합을 추가하고 answer 증가
            candidateKey.add(set);
            answer++;
            return;
        }
        // 조합 만들기
        for (int i = idx; i < m; i++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            idx++;
            combination(idx, size, depth + 1, newSet);
        }
    }

    // 유일성 검사 메서드
    static boolean unique(HashSet<Integer> set) {
        List<String> list = new ArrayList<>();
        // 만들어진 조합으로 중복되는지 검사
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : set) {
                sb.append(relationCopy[i][idx]);
            }
            if(!list.contains(sb.toString())) {
                list.add(sb.toString());
            } else {
                return false;
            }
        }
        return true;
    }
}
