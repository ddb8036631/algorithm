package 깊이우선탐색;

public class 프로그래머스_L3_네트워크 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, computers, visit);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int idx, int[][] computers, boolean[] visit) {
        visit[idx] = true;

        for (int j = 0; j < computers[idx].length; j++) {
            if (j != idx && !visit[j] && computers[idx][j] == 1) {
                dfs(j, computers, visit);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        solution(n, computers);
    }
}
