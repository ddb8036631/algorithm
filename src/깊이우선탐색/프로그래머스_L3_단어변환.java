package 깊이우선탐색;

public class 프로그래머스_L3_단어변환 {
    static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            dfs(begin, target, i, words, visit, 0);
        }

        answer = answer == Integer.MAX_VALUE ? 0 : answer;

        return answer;
    }

    public static void dfs(String now, String target, int idx, String[] words, boolean[] visit, int depth) {
        visit[idx] = true;

        int cnt = 0;
        for (int i = 0; i < words[idx].length(); i++) {
            if (cnt >= 2) break;

            if (now.charAt(i) != words[idx].charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1) {
            if (words[idx].equals(target)) {
                visit[idx] = false;

                answer = Math.min(answer, depth + 1);

                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visit[i]) {
                    dfs(words[idx], target, i, words, visit, depth + 1);
                }
            }
        }

        visit[idx] = false;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};

        solution(begin, target, words);
    }
}
