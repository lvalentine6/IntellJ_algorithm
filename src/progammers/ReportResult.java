package progammers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // HashSet으로 중복제거
        HashSet<String> reportSet = new HashSet<>();
        for(String s : report) {
            reportSet.add(s);
        }

        // Key(신고당한사람) : Value(신고자) 로 HashMap 선언

        // 신고당한사람 카운팅 하는 Hashmap 만들기

        // 카운팅을 기반으로 answer 배열 채우기
        return answer;
    }

    public static void main(String[] args) {
        ReportResult rr = new ReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        System.out.println(rr.solution(id_list, report, k));
    }
}
