package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14539_GridPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int n = 1; n <= N; n++) {
            sb.append("Case #" + n + ":\n");

            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = info[0], c = info[1], w = info[2], h = info[3];

            for (int i = 0; i < r * h + r + 1; i++) {
                for (int j = 0; j < c * w + c + 1; j++) {
                    if (i % (h + 1) == 0) {
                        if (j % (w + 1) == 0) sb.append("+");
                        else sb.append("-");
                    } else {
                        if (j % (w + 1) == 0) sb.append("|");
                        else sb.append("*");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
