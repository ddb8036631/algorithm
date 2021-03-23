package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

        int idx_a = 0, idx_b = 0, idx = 0;
        int[] result = new int[N + M];

        while (idx_a < N && idx_b < M) {
            if (A[idx_a] >= B[idx_b]) result[idx++] = B[idx_b++];
            else if (A[idx_a] < B[idx_b]) result[idx++] = A[idx_a++];
        }

        while (idx_a < N)
            result[idx++] = A[idx_a++];

        while (idx_b < M)
            result[idx++] = B[idx_b++];

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N + M; i++) sb.append(result[i] + " ");

        System.out.println(sb);
    }
}
