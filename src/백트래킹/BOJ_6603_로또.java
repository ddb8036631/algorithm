package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6603_로또 {
    static int[] input;
    static boolean[] used;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (input[0] == 0) break;

            used = new boolean[input.length];
            comb(1, 0, new StringBuilder(""));
            answer.append("\n");
        }

        System.out.println(answer);
    }

    static void comb(int idx, int cnt, StringBuilder sb) {
        if (cnt == 6) {
            answer.append(sb + "\n");
            return;
        }

        if (idx == input.length) return;

        for (int i = idx; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                comb(i, cnt + 1, new StringBuilder(sb).append(input[i] + " "));
                used[i] = false;
            }
        }
    }
}
