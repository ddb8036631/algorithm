package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4821_페이지세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            String[] splited = br.readLine().split(",");
            int[] cnt = new int[N + 1];
            int printpage = 0;

            for (String s : splited) {
                int[] range = Arrays.stream(s.split("-")).mapToInt(Integer::parseInt).toArray();

                if (range[0] > N) continue;
                else if (range.length == 1) cnt[range[0]]++;
                else if (range[0] > range[1]) continue;
                else {
                    for (int i = range[0]; i <= Math.min(range[1], N); i++) {
                        cnt[i]++;
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (cnt[i] > 0) printpage++;
            }

            sb.append(printpage + "\n");
        }

        System.out.println(sb);
    }
}
