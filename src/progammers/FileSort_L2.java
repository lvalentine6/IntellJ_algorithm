package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileSort_L2 {
    public static void main(String[] args) {
        String[] files = {"img12", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] answer = new String[files.length];

        // File 객체를 담을 list 생성
        List<File> list = new ArrayList<>();

        // subString으로 문자열 나누기
        for (int i = 0; i < files.length; i++) {
            String temp = files[i];
            // number 부분이 시작되었는지 판단하는 변수
            boolean flag = false;
            // number 부분의 시작과 끝 인덱스 변수, number 부분의 길이 변수
            int start = 0;
            int end = 0;
            int cnt = 0;
            for (int j = 0; j < temp.length(); j++) {
                // number 문자가 나오지 않았다는것
                if (!flag) {
                    if (Character.isDigit(temp.charAt(j))) {
                        flag = true;
                        start = j;
                        cnt++;
                    }
                    // number 문자가 시작 되었으면
                } else {
                    if (cnt != 5) {
                        // 숫자라면
                        if (Character.isDigit(temp.charAt(j))) {
                            cnt++;
                            // number 부분이 끝났다는 것
                        } else {
                            end = j - 1;
                            break;
                        }
                    } else {
                        end = j - 1;
                        break;
                    }
                }
            }
            // end가 0이면 tail이 없다는 의미
            if (end == 0) {
                end = temp.length() - 1;
            }

            // FIle 리스트에 값 삽입
            list.add(new File(temp.substring(0, start), temp.substring(start, end + 1), temp.substring(end + 1), ""));
        }

        // 1순위 - head값을 오름차순, 2순위 number의 값을 오름차순으로 정렬
        list.sort(Comparator.comparing(File::getHead).thenComparing(File::getNumber));

        // list에서 str을 answer 배열에 삽입
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getStr();
        }

        System.out.println(Arrays.toString(answer));
    }

    // File 클래스
    static class File {
        String head;
        String number;
        String tail;
        String str;

        // 생성자
        File(String head, String number, String tail, String str) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.str = str;
        }

        // String을 만들어 만환하는 메서드
        public String getStr() {
            str = head + number + tail;
            return str;
        }

        // head를 소문자로 바꾸어 반환하는 메서드
        public String getHead() {
            return head.toLowerCase();
        }

        // number를 Integer로 바꾸어 반환하는 메서드
        public int getNumber() {
            return Integer.parseInt(number);
        }
    }
}
