package progammers;

import java.util.*;

public class kPrimeNumber_L2 {
    static String[] arr;
    static List<String> list;
    static int answer;

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        answer = 0;

        // 진수 변환후 배열로
        arr = Integer.toString(n, k).split("");

        // 양쪽을 체크하기 위해 list 생성
        list = new ArrayList<>();
        list.add("n");
        for (String s : arr) {
            list.add(s);
        }
        list.add("n");

        for (int i = 1; i < arr.length; i++) {
            com("", 1, i, 0);
        }

        System.out.println(answer);

    }

    // 조합 생성 메서드
    static void com(String str, int idx, int cnt, int depth) {
        if (depth == cnt) {
            String result = list.get(idx - cnt - 1) + str;
            result += list.get(idx);
//            System.out.println(result);
            isPrimeNumber(result);
            return;
        }

        for (int i = idx; i <= arr.length; i++) {
            com(str + list.get(i), i + 1, cnt, depth + 1);
            if (!str.equals("")) {
                return;
            }
        }
    }

    // 소수 판별 메서드
    static void isPrimeNumber(String result) {
        int l = result.length() - 2;
        String prime = result.substring(1, result.length() - 1);
        char start = result.charAt(0);
        char end = result.charAt(result.length() - 1);
        boolean b = false;
        if((start == 'n' && end == 'n') || (start == 0 && end == 'n') || (start == 'n' && end == '0') || (start == 0 && end == 0)) {
            if(l == 1 && !(prime.equals(0))) {
                return;
            } else if (l == 2 && prime.charAt(prime.length() - 1) == 0) {
                return;
            } else {
                String temp = prime.substring(1, prime.length() - 1);
                if(!temp.contains("0")) {
                    int n = Integer.parseInt(prime);
                    for (int i = 2; i <= Math.sqrt(n); i++) {
                        if(n % i == 0) {
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        if(!b) {
            answer++;
        }
    }
}
