package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_20952_게임개발자승희 {
    static int N, M;
    static long[] A, B;
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long[] sum = new long[M];
        HashSet<Long> set = new HashSet<>();
        sum[0] = B[0] % MOD;
        set.add(sum[0]);

        for (int i = 1; i < M; i++) {
            sum[i] = (sum[i - 1] + B[i]) % MOD;
            set.add(sum[i]);
        }

        ArrayList<Long> list = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            long delta = ((A[i] / 7 + 1) * 7) % MOD - A[i];

            if (set.contains(delta)) {
                cnt++;
                continue;
            }

            list.add((A[i] + sum[M - 1]) % MOD);
        }

        StringBuilder answer = new StringBuilder();

        if (cnt == N) {
            answer.append(N + "\n");
            for (int i = 0; i < N; i++) answer.append(A[i] + " ");
        } else {
            answer.append(list.size() + "\n");
            for (long num : list) answer.append(num + " ");
        }

        System.out.println(answer);
    }
}
