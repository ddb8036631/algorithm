package 최장증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2550_전구 {
    static Pair[] pairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bulbs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        pairs = new Pair[N];
        dp = new int[N];
        Pair[] tracking = new Pair[N];
        int idx = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int target = switches[i];

            for (int j = 0; j < N; j++) {
                if (bulbs[j] == target) {
                    pairs[i] = new Pair(j, target);
                    break;
                }
            }
        }

        dp[0] = pairs[0].first;
        tracking[0] = new Pair(idx, pairs[0].second);

        for (int i = 1; i < N; i++) {
            if (dp[idx] < pairs[i].first) {
                dp[++idx] = pairs[i].first;
                tracking[i] = new Pair(idx, pairs[i].second);
            } else {
                int target = binarySearch(idx, pairs[i].first);
                dp[target] = pairs[i].first;
                tracking[i] = new Pair(target, pairs[i].second);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        for (int i = N - 1; i >= 0; i--) {
            if (tracking[i].first == idx) {
                pq.add(tracking[i].second);
                idx--;
            }
        }

        answer.append(pq.size());
        answer.append("\n");

        while (!pq.isEmpty()) {
            answer.append(pq.poll());
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
