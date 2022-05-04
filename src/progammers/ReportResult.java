package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ReportResult {
    public static void main(String[] args) {
        ReportResult rr = new ReportResult();
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(rr.solution(id_list, report, k));
        // 1. 신고당한 리스트 작성
        // 2. k값을 넘으면 신고자에게 결과 통보

    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] cnt = new int[id_list.length];

        // 중복 제거
        String [] result = Arrays.stream(report).distinct().toArray(String[] :: new);
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < result.length; j++) {
                String[] temp = result[j].split(" ");
                if(id_list[i].equals(temp[1])) {
                    cnt[i]++;
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] >= k) {
                list.add(id_list[i]);
            }
        }
        System.out.println(list);
        System.out.println(Arrays.toString(cnt));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < result.length; j++) {
                String[] temp = result[j].split(" ");
                if(list.get(i).equals(temp[1])) {
                    list2.add(temp[0]);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(id_list[i].equals(list2.get(j))) {
                    answer[i]++;
                }
            }
        }
        System.out.println(list2);
        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
