package progammers;

public class WeirdStringMake {
    public static void main(String[] args) {
        String s = "try hello world";
        String[] st = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length; i++) {
            String[] temp = st[i].split("");
            for (int j = 0; j < temp.length; j++) {
                if (j % 2 == 0) {
                    sb.append(temp[j].toUpperCase());
                } else {
                    sb.append(temp[j]);
                }
            }
            sb.append(" ");
        }
        String answer = sb.toString().trim();

        System.out.println(answer);
    }
}
