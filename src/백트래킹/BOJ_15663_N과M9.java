package 백트래킹;

import java.util.*;

public class BOJ_15663_N과M9 {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static Set<String> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        used = new boolean[N];
        answer = new LinkedHashSet<>();

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        solve(0, "");

        for (String s : answer)
            System.out.println(s);
    }

    static void solve(int cnt, String s) {
        if (cnt == M) {
            answer.add(s);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                solve(cnt + 1, s + arr[i] + " ");
                used[i] = false;
            }
        }
    }
}
