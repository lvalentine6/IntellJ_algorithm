package progammers;

public class RightParenthesis_L2 {
	public static void main(String[] args) {
		String s = "()))((()";
		boolean answer = true;

		int cnt = 0;

		// 첫번째 괄호가 )이면 false
		if(s.charAt(0) == ')') {
			answer = false;
		}
		
		for(int i=0; i<s.length(); i++) {
			// 열린 괄호라면
			if(s.charAt(i) == '(') {
				cnt++;
			}
			else {
				// 열린 괄호보다 닫힌 괄호가 많으면
				if(cnt <= 0) {
					answer = false;
				}
				// 열린 괄호가 있으면
				cnt--;
			}
		}
		if(cnt != 0) {
			answer = false;
		}
		System.out.println(answer);
		
	}
}
