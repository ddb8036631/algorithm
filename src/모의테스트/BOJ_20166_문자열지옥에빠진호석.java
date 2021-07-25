package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20166_문자열지옥에빠진호석 {
    static int N, M, K;
    static char[][] map;
    static String[] words;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static HashMap<String, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        map = new char[N][M];
        words = new String[K];
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
        for (int i = 0; i < K; i++) {
            words[i] = br.readLine();
            hashMap.put(words[i], 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, String.valueOf(map[i][j]));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (String key : words) answer.append(hashMap.get(key) + "\n");
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt, String s) {
        if (hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s) + 1);

        if (cnt == 5) return;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];

            if (nx < 0) nx = N - 1;
            else if (nx > N - 1) nx = 0;
            if (ny < 0) ny = M - 1;
            else if (ny > M - 1) ny = 0;

            dfs(nx, ny, cnt + 1, s + map[nx][ny]);
        }
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

