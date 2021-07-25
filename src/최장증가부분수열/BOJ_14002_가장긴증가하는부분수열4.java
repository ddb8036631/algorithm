package 최장증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_14002_가장긴증가하는부분수열4 {
    static int[] arr;
    static int[] dp;
    static Pair[] tracking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N];
        tracking = new Pair[N];

        dp[0] = arr[0];
        tracking[0] = new Pair(0, arr[0]);
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (dp[idx] < arr[i]) {
                dp[++idx] = arr[i];
                tracking[i] = new Pair(idx, arr[i]);
            } else {
                int targetIdx = binarySearch(idx, arr[i]);
                dp[targetIdx] = arr[i];
                tracking[i] = new Pair(targetIdx, arr[i]);
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (idx == tracking[i].first) {
                stack.push(tracking[i].second);
                idx--;
            }
        }

        StringBuilder answer = new StringBuilder(String.valueOf(stack.size()));
        answer.append("\n");

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
            answer.append(" ");
        }

        System.out.println(answer);
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

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
