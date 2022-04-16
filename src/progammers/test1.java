package progammers;

public class test1 {
    public static void main(String[] args) {
        int n = 6;
        int answer = 0;
        int max = 0;
        while (n!=126) {
            String temp = Integer.toBinaryString(n);
            int cnt = 0;
            for (int i = 0; i < temp.length(); i++) {
                char ch = temp.charAt(i);
                if(ch == '1') {
                    cnt++;
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = n;
            }
            n++;
        }
        System.out.println(answer);
    }
}
