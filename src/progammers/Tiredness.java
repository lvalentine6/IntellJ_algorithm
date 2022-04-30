package progammers;

public class Tiredness {
    public static void main(String[] args) {
        Tiredness t = new Tiredness();
        int k = 80;
        int[][] dungeons = 	{{80,20},{50,40},{30,10}};
        System.out.println(t.solution(k, dungeons));
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        // 완전탐색 DFS 이용해야 할듯

        int dsize = dungeons.length;
        return answer;
    }

    public int re(int cnt, int f, int s, int dsize) {
        if(cnt == dsize) return cnt;


        return f;
    }
}
