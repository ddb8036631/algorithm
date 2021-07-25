package 최장증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12738_가장긴증가하는부분수열3 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N];
        dp[0] = arr[0];
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] > dp[idx]) {
                dp[++idx] = arr[i];
            } else {
                int targetIdx = binarySearch(idx, arr[i]);
                dp[targetIdx] = arr[i];
            }
        }

        System.out.println(idx + 1);
    }

    static int binarySearch(int high, int target) {
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (dp[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
