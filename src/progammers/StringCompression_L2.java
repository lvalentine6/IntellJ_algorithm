package progammers;

public class StringCompression_L2 {
    public static void main(String[] args) {
        String s = "abcabcdede";
        // 압축이 안되었다면 리턴은 s의 길이
        int answer = s.length();

        // 문자열 길이가 반을 넘어가면 압축을 못하므로
        for (int i = 1; i <= s.length() / 2; i++) {
            // 압축 문자열
            String temp = s.substring(0,i);
            // 압축 카운트
            int cnt = 1;
            // 현재 문자열
            String cs = "";
            StringBuilder sb = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                // 다음 문자열의 길이가 압축단위보다 작으면 나머지 넣기
                if(j + i >= s.length()) {
                    cs = s.substring(j, s.length());
                } else {
                    cs = s.substring(j, j + i);
                }
                // 현재 문자열과 다음 문자열이 같다면
                if(temp.equals(cs)) {
                    cnt++;
                    // 업축하지 못한다면
                } else if(cnt == 1){
                    sb.append(temp);
                    temp = cs;
                    // 압축이 끝나면
                } else {
                    sb.append(cnt).append(temp);
                    temp = cs;
                    cnt = 1;
                }
            }
            if(temp.length() != i) {
                sb.append(temp);
                answer = Math.min(answer, sb.toString().length());
            }
        }
        System.out.println(answer);
    }
}
