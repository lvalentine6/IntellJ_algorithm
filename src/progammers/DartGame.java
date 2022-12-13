package progammers;

public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1D#2S*3S";
        int answer = 0;

        // 1. 문자열 마다 검사

        int[] score = new int[3];
        String tempString = "";
        int tempNum = 0;
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            // char를 이용해서 문자열 자르기
            char c = dartResult.charAt(i);

            // 숫자라면
            if (c >= '0' && c <= '9') {
                tempString += String.valueOf(c);
                // 점수 계산
            } else if (c == 'S' || c == 'D' || c == 'T') {
                tempNum = Integer.parseInt(tempString);
                if (c == 'S') {
                    tempNum = (int) Math.pow(tempNum, 1);
                } else if (c == 'D') {
                    tempNum = (int) Math.pow(tempNum, 2);
                } else {
                    tempNum = (int) Math.pow(tempNum, 3);
                }
                score[idx++] = tempNum;
                tempString = "";
            } else {
                // 스타상, 아차상
                if (c == '#') {
                    score[idx - 1] *= -1;
                } else {
                    score[idx - 1] *= 2;
                    if (idx - 2 <= 0) {
                        score[idx - 2] *= 2;
                    }
                }
            }
        }

        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }

        System.out.println(answer);
    }
}
