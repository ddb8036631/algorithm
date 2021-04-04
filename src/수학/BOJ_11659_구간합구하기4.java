package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] left = new int[N + 1];
        int[] right = new int[N + 1];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += arr[i];
            left[i] = sum;
        }

        sum = 0;
        for (int i = N; i >= 1; i--) {
            sum += arr[i];
            right[i] = sum;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int subsum = total;

            if (a - 1 >= 1) subsum -= left[a - 1];
            if (b + 1 <= N) subsum -= right[b + 1];

            answer.append(subsum + "\n");
        }

        System.out.println(answer);
    }
}
