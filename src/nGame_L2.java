import java.util.Arrays;

public class nGame_L2 {
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;
        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 십진법 번호
        int num = 0;
        // 말해야 하는 순서
        int order = 1;

        // 탐색 시작
        while (sb.length() < t) {
            // 번호를 n진수로 변환후 배열로 만들기
            String[] temp = Integer.toString(num++, n).split("");
            // 배열을 돌면서 순서에 맞게 StringBuilder에 추가
            for (int i = 0; i < temp.length; i++) {
                // 순서가 맴버수보다 커지면 1번으로 초기화
                if(order > m) {
                    order = 1;
                }
                // 순서에 맞는 번호라면 StringBuilder에 추가
                if(order == p) {
                    sb.append(temp[i]);
                }
                // StringBuilder의 크기가 t와 같다면 즉시 탐색종료
                if(sb.length() == t) {
                    break;
                }
                // 순서 증가
                order++;
            }
        }

        // StringBuilder를 String으로 변환후 대문자 변환
        answer = sb.toString().toUpperCase();
        System.out.println(answer);
    }
}
