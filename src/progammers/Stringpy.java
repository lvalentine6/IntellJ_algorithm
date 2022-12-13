package progammers;

public class Stringpy {
    public static void main(String[] args) {
        String s = "pPoooyY";
        boolean answer = true;
        int pc = 0;
        int yc = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.toLowerCase();
            char ch = s.charAt(i);
            if (ch == 'p') {
                pc++;
            } else if (ch == 'y') {
                yc++;
            }
        }
        if (pc == yc) {
            answer = true;
        } else {
            answer = false;
        }

        System.out.println(answer);
    }
}
