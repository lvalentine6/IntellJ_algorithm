package progammers;

import java.util.Map;
import java.util.TreeMap;

public class PCCP01_L1 {
	public static void main(String[] args) {
		int[] bandage = {5, 1, 5};
		int[][] attacks = {{2, 10}, {9, 15}, {10, 5},{11, 5}};
		int health = 30;

		int answer = 0;
		int time = 0;
		int status = 0;
		int maxHealth = health;

		int lastAttackTime = attacks[attacks.length - 1][0];
		Map<Integer, Integer> attacksMap = new TreeMap<>();

		for(int i = 0; i < attacks.length; i++) {
			attacksMap.put(attacks[i][0], attacks[i][1]);
		}

		for(int i = time; i <= lastAttackTime; i++) {
			if(attacksMap.containsKey(i)) {
				health -= attacksMap.get(i);
				if(health < 0) {
					health = -1;
					break;
				}
				status = 0;
				continue;
			}

			health += bandage[1];
			status++;

			if(health > maxHealth) {
				health = maxHealth;
				status++;
				continue;
			}

			if(status == bandage[0]) {
				health += bandage[2];
				if(health > maxHealth) {
					health = maxHealth;
				}
				status = 0;
				continue;
			}
		}
		if(health < 1) {
			health = -1;
		}
		answer = health;
		// return answer;
	}
}
