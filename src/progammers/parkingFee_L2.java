package progammers;

import java.util.*;

public class parkingFee_L2 {
    static Map<String, Integer> parseMap;

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT", "23:11 1234 IN"};

        // 출입시간을 기록하기 위한 map
        Map<String, String> map = new HashMap<>();

        parseMap = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] tempRecords = records[i].split(" ");
            // 입차라면
            if (tempRecords[2].equals("IN")) {
                map.put(tempRecords[1], tempRecords[0]);
                // 출차라면 입차시간, 출차시간, 차량번호를 cul에 넘김
            } else {
                parse(map.get(tempRecords[1]), tempRecords[0], tempRecords[1]);
                map.remove(tempRecords[1]);
            }
        }

        // map에 남아있는 차량이 있다면
        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                parse(map.get(s), "23:59", s);
            }
        }

        // 계산 메서드 호출
        cul(fees);

        List<Integer> list = new ArrayList<>();
        for (String key : parseMap.keySet()) {
            list.add(parseMap.get(key));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    static void parse(String in, String out, String carNum) {
        String[] outTemp = out.split(":");
        int outMin = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
        String[] inTemp = in.split(":");
        int inMin = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
        int dif = outMin - inMin;
        parseMap.put(carNum, parseMap.getOrDefault(carNum, 0) + dif);
    }

    static void cul(int[] fees) {
        for (String key : parseMap.keySet()) {
            if (parseMap.get(key) < fees[0]) {
                parseMap.put(key, fees[1]);
            } else {
                double addTime = parseMap.get(key) - fees[0];
                addTime = Math.ceil(addTime / fees[2]);
                int result = (int) (addTime * fees[3] + fees[1]);
                parseMap.put(key, result);
            }
        }
    }
}
