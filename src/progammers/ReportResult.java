package progammers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {
    public static void main(String[] args) {
        ReportResult rr = new ReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        System.out.println(rr.solution(id_list, report, k));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // HashSet으로 중복제거
        HashSet<String> reportSet = new HashSet<>();
        for (String s : report) {
            reportSet.add(s);
        }

        // Key(신고당한사람) : Value(신고자) 로 HashMap 선언
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        for (String s : reportSet) {
            // split으로 문자열 나누기
            String[] temp = s.split(" ");
            String reporter = temp[0];
            String reportee = temp[1];
            ArrayList<String> list = reportMap.get(reportee);
            // value가 비어있다면
            if (reportMap.get(reportee) == null) {
                // 리스트 초기화
                list = new ArrayList<>();
            }
            list.add(reporter);
            reportMap.put(reportee, list);
        }

        // 신고자에게 정지 메일을 카운팅 하는 Hashmap 만들기
        HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
        // reportMap에서 value list를 가져오기
        for (ArrayList<String> list : reportMap.values()) {
            // 그 값이 k보다 크다면
            if (list.size() >= k) {
                for (String s : list) {
                    // cntMap에 신고자를 key로 넣고 value에 메일 발송 카운트
                    cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
                }
            }
        }

        // 카운팅을 기반으로 answer 배열 채우기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = cntMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}
