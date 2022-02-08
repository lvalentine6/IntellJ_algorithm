package progammers;

public class SkillTree_L2 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = 0;

        for(String temp : skill_trees) {
            String sk = temp;
            for (int j = 0; j < temp.length(); j++) {
                // 한글자씩 검사
                String st = String.valueOf(temp.charAt(j));
                // 스킬에 없는 문자 공백으로 바꿈
                if(!skill.contains(st)) {
                    sk = sk.replace(st, "");
                }
            }
            // 문자열들을 0번째에서 찾을수 있다면 올바른 스킬트리
            if(skill.indexOf(sk) == 0) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
