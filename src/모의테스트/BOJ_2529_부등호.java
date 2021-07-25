package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2529_부등호 {
    static int K;
    static String[] oper;
    static boolean[] used;
    static String max = "0", min = "9876543210";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        oper = br.readLine().split(" ");
        used = new boolean[10];

        for (int i = 0; i <= 9; i++) {
            used[i] = true;
            dfs(0, String.valueOf(i), i);
            used[i] = false;
        }

        System.out.println(max + "\n" + min);
    }

    static void dfs(int idx, String s, int prev) {
        if (idx == K) {
            max = Long.parseLong(s) > Long.parseLong(max) ? s : max;
            min = Long.parseLong(s) < Long.parseLong(min) ? s : min;

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;

            if ((oper[idx].equals("<") && prev < i) || (oper[idx].equals(">") && prev > i)) {
                used[i] = true;
                dfs(idx + 1, s + i, i);
                used[i] = false;
            }
        }
    }
}
