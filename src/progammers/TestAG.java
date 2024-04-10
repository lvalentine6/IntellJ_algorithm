package progammers;

public class TestAG {

	static int maxScore = 0;
	static int[] answer = {-1};

	public int[] solution(int n, int[] info) {
		int[] comb = new int[n];
		recursion(0, info, comb, n, 0);

		return answer;
	}

	public void recursion(int start, int[] aBoard, int[] comb, int n, int idx) {
		if (idx == n) {
			getScore(aBoard, comb);
			return;
		}

		for (int i = start; i < 11; i++) {
			comb[idx] = i;
			recursion(i, aBoard, comb, n, idx + 1);
		}
	}

	public void getScore(int[] aBoard, int[] comb) {
		int[] rBoard = new int[aBoard.length];

		for (int i : comb) {
			rBoard[10 - i]++;
		}

		int aScore = 0;
		int rScore = 0;
		int targetNum = 10;
		for (int i = 0; i < aBoard.length; i++) {
			if (aBoard[i] == 0 && rBoard[i] == 0) {
				continue;
			} else {
				if (aBoard[i] >= rBoard[i]) {
					aScore += targetNum;
				} else {
					rScore += targetNum;
				}
			}
			targetNum--;
		}

		if (rScore > aScore) {
			int[] temp = new int[rBoard.length];

			for (int i = 0; i < rBoard.length; i++) {
				temp[i] = rBoard[i];
			}

			int dif = rScore - aScore;

			if (dif >= maxScore) {
				maxScore = dif;
				answer = temp;
			}
		}
	}

}
