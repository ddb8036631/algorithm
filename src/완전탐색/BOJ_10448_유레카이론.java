package 완전탐색;

import java.io.*;

public class BOJ_10448_유레카이론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        int[] T = new int[1001];

        for (int i = 1; i <= 1000; i++) {
            T[i] = i * (i + 1) / 2;
        }

        while (TC-- > 0) {
            int K = Integer.parseInt(br.readLine());
            boolean found = false;

            outer:
            for (int i = 1; i <= 1000; i++) {
                for (int j = i; j <= 1000; j++) {
                    for (int k = j; k <= 1000; k++) {
                        int sum = T[i] + T[j] + T[k];

                        if(sum > K) break;
                        else if (sum == K) {
                            found = true;
                            break outer;
                        }
                    }
                }
            }

            if (found) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
    }
}
