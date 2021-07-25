package 수학;

import java.io.*;
import java.util.Arrays;

public class BOJ_10953_A더하기B6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            int[] num = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            bw.write(num[0] + num[1] + "\n");
        }

        bw.flush();
    }
}
