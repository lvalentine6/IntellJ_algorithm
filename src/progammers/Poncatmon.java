package progammers;

import java.util.HashSet;

public class Poncatmon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        int answer = 0;

        int max = nums.length / 2;
        HashSet set = new HashSet();

        for(int i : nums) {
            set.add(i);
        }

        if(set.size() > max) {
            answer = max;
        }
        else {
            answer = set.size();
        }



    }
}
