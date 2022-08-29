package progammers;

import java.util.*;

public class parkingFee_L2 {
    static int[] answer;
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Set<String> set = new TreeSet<>();
        List<String> list = new LinkedList<>();

        for (int i = 0; i < records.length; i++) {
            String[] tempRecords = records[i].split(" ");
            set.add(tempRecords[1]);
            if(tempRecords[2].equals("IN")) {
                StringBuilder sb = new StringBuilder();
                sb.append(tempRecords[0]).append(" ").append(tempRecords[1]);
                list.add(sb.toString());
            } else {
                for (int j = 0; j < list.size(); j++) {
                    String[] tempList = list.get(j).split(" ");
                    if(tempList[1].equals(tempRecords[1])) {
                        cul(tempList[0], tempRecords[0], tempRecords[1]);
                    }
//                    list.remove(j);
                }
            }
        }
        System.out.println(list);
        answer = new int[set.size()];
    }
    static void cul(String in, String out, String carNum) {
        System.out.println(in);
        System.out.println(out);
        System.out.println(carNum);
    }
}
