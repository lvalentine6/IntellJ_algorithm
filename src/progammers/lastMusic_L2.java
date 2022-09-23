package progammers;

import java.util.ArrayList;
import java.util.List;

public class lastMusic_L2 {
    public static void main(String[] args) {
//        String m = "ABCDEFG";
        String m = "CC#BCC#BCC#BCC#B";
//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = "";

        roof1 : for (int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            int difHour = Integer.parseInt(temp[1].split(":")[0]) - Integer.parseInt(temp[0].split(":")[0]);
            int difMinute = Integer.parseInt(temp[1].split(":")[1]) - Integer.parseInt(temp[0].split(":")[1]);
            int minute = 0;
            if (difHour != 0) {
                minute += difHour * 60;
            }
            minute += difMinute;
            System.out.println(minute);

            int cnt = 0;
            int idx = 0;
            List<String> list = new ArrayList<>();
            while (cnt <= minute) {
                if (idx >= temp[3].length()) {
                    idx = 0;
                }
                if (idx + 1 < temp[3].length() && temp[3].charAt(idx + 1) == '#') {
                    list.add(temp[3].charAt(idx) + "#");
                    idx += 2;
                    cnt++;
                    continue;
                }
                list.add(String.valueOf(temp[3].charAt(idx++)));
                cnt++;
            }
            System.out.println(list);

            StringBuilder sb = new StringBuilder();
            roof2 :
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < m.length(); k++) {
                    if (j >= list.size() - m.length()) {
                        break roof2;
                    }
                    sb.append(list.get(j + k));
                    if (sb.toString().equals(m)) {
                        answer = temp[2];
                    }
                }
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        if (answer.equals("")) {
            answer = "(none)";
        }
        System.out.println(answer);
    }
}
