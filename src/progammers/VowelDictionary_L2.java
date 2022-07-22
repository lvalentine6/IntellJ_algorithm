package progammers;

public class VowelDictionary_L2 {
    static String[] arr;
    static int cnt;
    public static void main(String[] args) {
        String word = "AAAE";
        int answer = 0;

        cnt = 0;
        arr = new String[]{"A", "E", "I", "O", "U"};

        recursion(word, "", 0);
        answer = cnt;
        System.out.println(answer);



    }
    static void recursion(String word, String str, int depth) {
        if(word.equals(str)) {
            return;
        }
        if(depth == 5) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            cnt++;
            recursion(word, str + arr[i], depth + 1);
        }
    }
}
