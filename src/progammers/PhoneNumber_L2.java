package progammers;

import java.util.HashMap;

public class PhoneNumber_L2 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;

        HashMap<String, Integer> hs = new HashMap<>();

        // 전화번호 해시맵에 넣기
        for (int i = 0; i < phone_book.length; i++) {
            hs.put(phone_book[i], i);
        }

        // containsKey과 substring으로 접두어인지 검사
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hs.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

    }
}
