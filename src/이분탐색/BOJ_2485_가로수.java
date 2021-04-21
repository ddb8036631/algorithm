package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2485_가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int gcd = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            gcd = GCD(Math.max(gcd, gap), Math.min(gcd, gap));
        }

        for (int i = 0; i < N - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            answer += gap / gcd - 1;
        }

        System.out.println(answer);
    }

    static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
