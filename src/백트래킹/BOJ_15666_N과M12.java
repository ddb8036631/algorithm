package 백트래킹;

import java.util.*;

public class BOJ_15666_N과M12 {
    static int N, M;
    static int[] arr;
    static Set<String> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        answer = new LinkedHashSet<>();

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        solve(0, 0, "");

        for (String s : answer)
            System.out.println(s);
    }

    static void solve(int idx, int cnt, String s) {
        if (cnt == M) {
            answer.add(s);
            return;
        }

        for (int i = idx; i < N; i++)
            solve(i, cnt + 1, s + arr[i] + " ");
    }
}
