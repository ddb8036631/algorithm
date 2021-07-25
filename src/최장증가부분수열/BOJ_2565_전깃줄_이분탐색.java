package 최장증가부분수열;

import java.util.Scanner;

public class BOJ_2565_전깃줄_이분탐색 {
    static int[] poles;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        poles = new int[501];
        dp = new int[N + 1];
        int len = 1;

        for (int i = 0; i < N; i++) poles[sc.nextInt()] = sc.nextInt();

        for (int i = 1; i < poles.length; i++) {
            if (poles[i] == 0) continue;

            if (dp[len - 1] < poles[i]) {
                dp[len] = poles[i];
                len++;
            } else {
                int target = binarySearch(0, len, i);
                dp[target] = poles[i];
            }
        }

        System.out.println(N - len + 1);

    }

    static int binarySearch(int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (dp[mid] < poles[target]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return low;
    }
}
