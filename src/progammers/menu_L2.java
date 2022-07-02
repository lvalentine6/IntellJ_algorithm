package progammers;

import java.util.TreeMap;

public class menu_L2 {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = {};

        TreeMap<String, Integer> menu = new TreeMap<>();

        for (int i = 0; i < orders.length; i++) {
            String[] temp = orders[i].split("");
            for (String s : temp) {
                menu.put(s, menu.getOrDefault(s, 0) + 1);
            }
            // System.out.println(Arrays.toString(temp));
        }
        System.out.println(menu);

    }
}
