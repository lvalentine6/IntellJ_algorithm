package progammers;

import java.util.ArrayList;
import java.util.List;

public class lastMusic_L2 {
    public static void main(String[] args) {
//        String m = "ABCDEFG";
        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = "";

        for (int i = 0; i < musicinfos.length; i++) {
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
            while (cnt < minute) {
                if(idx >= temp[3].length()) {
                    idx = 0;
                }
                if(idx + 1 < temp[3].length() && temp[3].charAt(idx + 1) == '#') {
                    cnt--;
                }
                list.add(temp[3].charAt(idx++));
                cnt++;
            }
            System.out.println(list);

//            String result = sb.toString();
//
//            sb = new StringBuilder();
//            for (int j = 0; j < result.length(); j++) {
//                for (int k = 0; k <= m.length(); k++) {
//                    if(result.charAt(k) == '#') {
//                        sb.append(result.charAt(k));
//                        continue;
//                    }
//                    sb.append(result.charAt(j + k));
//                }
//                if(sb.toString().equals(m)) {
//                    answer = temp[2];
//                    break;
//                }
//                sb = new StringBuilder();
//            }
        }
        if(answer.equals("")) {
            answer = "(none)";
        }
        System.out.println(answer);
    }
}
