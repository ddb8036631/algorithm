package 수학;

import java.io.*;
import java.util.Arrays;

public class BOJ_11024_더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0)
            bw.write(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).reduce(0, Integer::sum) + "\n");

        bw.flush();
    }
}
