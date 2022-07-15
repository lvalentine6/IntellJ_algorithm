package progammers;

import java.util.Arrays;
import java.util.StringTokenizer;

public class RankSearch_L2 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer = new int[query.length];

        Volunteer[] volunteer = new Volunteer[info.length];
        for (int i = 0; i < info.length; i++) {
            StringTokenizer st = new StringTokenizer(info[i]);
            volunteer[i] = new Volunteer(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
        }


        Query[] queries = new Query[query.length];
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll("( and )", " ");
            StringTokenizer st = new StringTokenizer(query[i]);
            queries[i] = new Query(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            String l = queries[i].getLanguage();
            String p = queries[i].getPosition();
            String t = queries[i].getType();
            String f = queries[i].getFavorite();
            int s = queries[i].getScore();
            for (Volunteer value : volunteer) {
                String vl = value.getLanguage();
                String vp = value.getPosition();
                String vt = value.getType();
                String vf = value.getFavorite();
                int vs = value.getScore();

                if (l.equals(vl) || l.equals("-")) {
                    if (p.equals(vp) || p.equals("-")) {
                        if (t.equals(vt) || t.equals("-")) {
                            if (f.equals(vf) || f.equals("-")) {
                                if (vs >= s) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
                answer[i] = cnt;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}

class Volunteer {
    public String getLanguage() {
        return language;
    }

    public String getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public String getFavorite() {
        return favorite;
    }

    public int getScore() {
        return score;
    }

    String language;
    String position;
    String type;
    String favorite;
    int score;

    Volunteer(String l, String p, String t, String f, int s) {
        this.language = l;
        this.position = p;
        this.type = t;
        this.favorite = f;
        this.score = s;
    }
}

class Query {
    public String getLanguage() {
        return language;
    }

    public String getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public String getFavorite() {
        return favorite;
    }

    public int getScore() {
        return score;
    }

    String language;
    String position;
    String type;
    String favorite;
    int score;

    Query(String l, String p, String t, String f, int s) {
        this.language = l;
        this.position = p;
        this.type = t;
        this.favorite = f;
        this.score = s;
    }
}
