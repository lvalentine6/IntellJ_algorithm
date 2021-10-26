package progammers;

import java.util.Arrays;

public class TwoInt {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int answer = 0;

        // temp 배열에 a, b 넣기
        int[] temp = {a,b};

        // 대소비교를 위해 정렬
        Arrays.sort(temp);

        // a와 b가 서로 같아질때까지 더함
        while(!(temp[0] == temp[1])) {
            answer += temp[0];
            temp[0] += 1;
        }

        // b를 더함
        answer += temp[1];

        System.out.println(answer);
        System.out.println(Arrays.toString(temp));

    }
}
