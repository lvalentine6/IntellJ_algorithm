package progammers;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer = {};

        // s의 맨 앞 {{ 부분 자르기
        s = s.substring(2, s.length());
        // s의 맨 뒤 }} 부분 자르고 },{ 부분 -로 변경
        s = s.substring(0, s.length()-2).replace("},{", "-");
        // -을 기준으로 자르기
        String[] temp = s.split("-");
        // 람다를 이용해서 길이별로 정렬
        Arrays.sort(temp, (a,b) -> (a.length()-b.length()));

        // 튜플을 위한 리스트 생성
        List<Integer> list = new ArrayList<>();

        for(String a : temp) {
            // ,을 기준으로 다시 나누기
            String[] temp2 = a.split(",");
            for (int i = 0; i < temp2.length; i++) {
                int n = Integer.parseInt(temp2[i]);
                // 튜플에 값이 없다면
                if(!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(answer));
    }
}
