package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChat_L2 {
    public static void main(String[] args) {
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        // 로그를 저장하기 위한 리스트
        List<String> list = new ArrayList<>();
        // 아이디와 닉네임을 저장하기 위한 해시맵
        HashMap<String,String> hm = new HashMap<>();
        for (int i= 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (temp[0].equals("Enter")) {
                hm.put(temp[1], temp[2]);
                list.add(temp[1]+"님이 들어왔습니다.");
            }else if(temp[0].equals("Leave")) {
                list.add(temp[1]+"님이 나갔습니다.");
            }else {
                hm.replace(temp[1],temp[2]);
            }
        }
        // 아이디로 저장된 리스트를 닉네임으로 변경
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
        int idx = list.get(i).indexOf("님");
            String id = list.get(i).substring(0,idx);
            answer[i] = hm.get(id)+list.get(i).substring(idx);
        }
        System.out.println(Arrays.toString(answer));
    }
}
