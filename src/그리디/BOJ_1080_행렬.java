package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
    static int N, M;
    static boolean[][] isChanged;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        isChanged = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) A[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) B[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) isChanged[i][j] = true;
            }
        }

        if (isSame()) {
            System.out.println(0);
            System.exit(0);
        } else {
            outer:
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= M - 3; j++) {
                    if (!isChanged[i][j]) continue;

                    cnt++;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            isChanged[k][l] = !isChanged[k][l];
                        }
                    }

                    if (isSame()) {
                        System.out.println(cnt);
                        System.exit(0);
                    }
                }
            }

            System.out.println(-1);
        }
    }

    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isChanged[i][j]) return false;
            }
        }

        return true;
    }
}
