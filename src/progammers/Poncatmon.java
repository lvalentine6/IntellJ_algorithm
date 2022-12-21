package progammers;

import java.util.HashSet;

public class Poncatmon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        int answer = 0;

        int num = nums.length / 2;

        // 중복을 제거하기 위해 해시셋에 넣기
        HashSet set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }

        // 두 값중 최소값을 리턴
        if (set.size() > num) {
            answer = num;
        } else {
            answer = set.size();
        }
    }
}
